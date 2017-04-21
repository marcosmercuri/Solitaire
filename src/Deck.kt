import java.util.*

class Deck {
    private fun getSuit(i: Int): String = when (i/13) {
        0 -> clubs
        1 -> diamonds
        2 -> hearts
        else -> spades
    }

    private val cards: Array<Card> = Array(52, { Card(it % 13, getSuit(it))})

    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    fun drawCard(): Card = cardsInDeck.removeAt(0)

    fun reset() {
        cardsInDeck = cards.toMutableList().onEach{ it.faceUp = false }
        Collections.shuffle(cardsInDeck)
    }
}
