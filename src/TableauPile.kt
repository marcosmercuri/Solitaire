class TableauPile(val cards:MutableList<Card> = mutableListOf()) {
    init {
        faceUpLastCard()
    }

    fun addCards(newCards: MutableList<Card>): Boolean {
        if (canAddNewCards(newCards)) {
            cards.addAll(newCards)
            return true
        }
        return false
    }

    private fun canAddNewCards(newCards: MutableList<Card>): Boolean {
        return (cards.isNotEmpty() && newCards.first().value == cards.last().value - 1 && suitCheck(newCards.first(), cards.last()))
            || (cards.isEmpty() && newCards.first().value == 12)
    }

    fun removeCards(tappedIndex: Int) {
        for (index in tappedIndex..cards.lastIndex) {
            cards.removeAt(tappedIndex)
        }
        faceUpLastCard()
    }

    private fun faceUpLastCard() {
        if (cards.isNotEmpty()) {
            cards.last().faceUp = true
        }
    }

    private fun suitCheck(c1: Card, c2: Card): Boolean {
        return (redSuits.contains(c1.suit) && blackSuits.contains(c2.suit))
            || (redSuits.contains(c2.suit) && blackSuits.contains(c1.suit))
    }
}
