object GameModel {
    val deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf()
    val foundationPiles = arrayOf(clubs, diamonds, hearts, spades).map(::FoundationPile)
    val tableaouPiles = Array(7, {TableauPile()})

    fun resetGame() {
        wastePile.clear()
        foundationPiles.forEach { it.reset() }
        deck.reset()

        tableaouPiles.forEachIndexed { index, tableauPile ->
            val cardsInPile: MutableList<Card> = Array(index + 1, {deck.drawCard()}).toMutableList()
            tableauPile.addCards(cardsInPile)
        }
    }

    fun onDeckTap() {
        if (deck.cardsInDeck.isNotEmpty()) {
            val drawCard = deck.drawCard()
            drawCard.faceUp = true
            wastePile.add(drawCard)
        } else {
            deck.cardsInDeck = wastePile.onEach{ it.faceUp = false }
            wastePile.clear()
        }
    }

    fun onWasteTap() {
        handleTap(wastePile)
    }

    private fun handleTap(cardPile: MutableList<Card>) {
        if (cardPile.isNotEmpty()) {
            val card = cardPile.last()
            if (playCards(mutableListOf(card))) {
                cardPile.remove(card)
            }
        }
    }

    private fun playCards(cards: MutableList<Card>): Boolean {
        if (cards.size == 1) {
            foundationPiles.forEach {
                if (it.addCard(cards.first())) {
                    return true
                }
            }
        }

        tableaouPiles.forEach {
            if (it.addCards(cards)) {
                return true
            }
        }

        return false
    }

    fun onFoundationTap(index: Int) {
        val foundationPile = foundationPiles[index]
        handleTap(foundationPile.cards)
    }

    fun onTableauTap(tableauIndex: Int, cardIndex: Int) {
        val tableauPile = tableaouPiles[tableauIndex]
        if (tableauPile.cards.isNotEmpty()) {
            val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)
            if (playCards(cards)) {
                tableauPile.removeCards(cardIndex)
            }
        }
    }
}
