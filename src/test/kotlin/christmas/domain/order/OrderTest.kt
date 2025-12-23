package christmas.domain.order

import christmas.domain.menu.Food
import org.junit.jupiter.api.Test

class OrderTest {

    @Test
    fun `할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정한다`() {
        val orderFood = OrderFood(2, Food.Main.크리스마스파스타)
    }

}