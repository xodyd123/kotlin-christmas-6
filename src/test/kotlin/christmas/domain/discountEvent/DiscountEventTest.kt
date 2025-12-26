package christmas.domain.discountEvent

import christmas.domain.menu.Food
import christmas.domain.order.Day
import christmas.domain.order.Order
import christmas.domain.order.OrderFood
import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class DiscountEventTest {

    @Test
    fun `이벤트_기간이고_조건을_만족하면_최종_결제금액이_할인_적용되어_반환된다`() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(1, Food.Main.티본스테이크),
            OrderFood(1, Food.Main.바비큐립),
            OrderFood(2, Food.Dessert.초코케이크),
            OrderFood(1, Food.Drink.제로콜라)
        )
        val discountMoney: Int = DiscountEvent.totalDiscount(Day.parse("3"), Order.create(orderFoods))
        val expectedFinalPay = 6246
        assertEquals(expectedFinalPay, discountMoney)
    }

    @Test
    fun `이벤트_기간이_아니면_할인이_0이다`() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(1, Food.Appetizer.타파스),
            OrderFood(1, Food.Drink.제로콜라)
        )
        val discountMoney: Int = DiscountEvent.totalDiscount(Day.parse("26"), Order.create(orderFoods))
        assertEquals(0, discountMoney)
    }
}