class FoundationPile(val suit: String) {
    val cards: MutableList<Card> = mutableListOf()

    fun reset() = cards.clear()

    fun addCard(card: Card): Boolean {
        val nextValue = if (cards.isEmpty()) 0 else cards.last().value + 1

        if (card.suit == suit && card.value==nextValue) {
            cards.add(card)
            return true
        }
        return false
    }
}
