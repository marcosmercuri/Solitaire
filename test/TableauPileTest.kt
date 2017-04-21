import junit.framework.TestCase.assertEquals
import org.junit.Test

class TableauPileTest {
    @Test
    fun addCards() {
        // given
        val tableauPile = TableauPile(mutableListOf(Card(12, spades)))
        val card = Card(11, hearts)

        // when
        tableauPile.addCards(mutableListOf(card))

        // then
        assertEquals(2, tableauPile.cards.size)
    }

    @Test
    fun removeCards() {
        // given
        val tableauPile = TableauPile(mutableListOf(Card(4, clubs), Card(3, diamonds), Card(2, spades, true)))

        // when
        tableauPile.removeCards(1)

        // then
        assertEquals(mutableListOf(Card(4, clubs, true)), tableauPile.cards)
    }
}
