package christmas.domain.order

import christmas.domain.menu.Food
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class OrderTest {

    @Test
    fun `할인_전_총_주문_금액이_12만원_이상일_때_샴페인_증정_대상이다`() {
        val orderFood1 = OrderFood(2, Food.Main.티본스테이크)
        val orderFood2 = OrderFood(2, Food.Appetizer.타파스) // 총 121,000

        val order = Order(orderFood1, orderFood2)
        assertTrue(order.isChampagneGiftEligible())

    }

    @Test
    fun `할인_전_총_주문_금액이_12만원_미만이면_샴페인_증정_대상이_아니다`() {
        val order = Order(
            OrderFood(2, Food.Main.크리스마스파스타), // 50,000
            OrderFood(1, Food.Drink.레드와인)         // 총 110,000
        )

        assertFalse(order.isChampagneGiftEligible())
    }

}