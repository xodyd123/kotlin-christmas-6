package christmas.domain.discountPolicy

import christmas.domain.discountpolicy.SpecialDiscountPolicy
import christmas.domain.menu.Food
import christmas.domain.order.Day
import christmas.domain.order.Order
import christmas.domain.order.OrderFood
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SpecialDiscountPolicyTest {

    @ParameterizedTest(name = "days={0} -> 1000")
    @ValueSource(strings = ["3", "10", "17", "24", "25", "31"])
    fun `3,10,17,24,25,31일에는_1000원_특별_할인을_받는다`(day: String) {
        val orderFoods = listOf<OrderFood>(OrderFood(2, Food.Main.크리스마스파스타))
        val order: Order = Order.create(orderFoods)
        val discountMoney = SpecialDiscountPolicy.discount(Day.parse(day), order)
        assertEquals(1000, discountMoney)
    }
}