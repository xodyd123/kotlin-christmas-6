package christmas.domain.discountPolicy

import christmas.domain.discountpolicy.ChristmasDiscountPolicy
import christmas.domain.menu.Food
import christmas.domain.order.Order
import christmas.domain.order.OrderFood
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ChristmasDiscountPolicyTest {

    @Test
    fun `12월_1일_에는_1_000원을_활인_받는다`() {
        val orderFoods = listOf<OrderFood>(OrderFood(2, Food.Main.크리스마스파스타))
        val order: Order = Order.create(orderFoods)
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val discountMoney = christmasDiscountPolicy.discount(1, order)
        assertEquals(1000, discountMoney)
    }

    @Test
    fun `12월_2일_에는_1_100원을_활인_받는다`() {
        val orderFoods = listOf<OrderFood>(OrderFood(2, Food.Main.크리스마스파스타))
        val order: Order = Order.create(orderFoods)
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val discountMoney = christmasDiscountPolicy.discount(2, order)
        assertEquals(1100, discountMoney)
    }

    @Test
    fun `12월_3일_에는_1_200원을_활인_받는다`() {
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val orderFoods = listOf<OrderFood>(OrderFood(2, Food.Main.크리스마스파스타))
        val order: Order = Order.create(orderFoods)
        val discountMoney = christmasDiscountPolicy.discount(day = 3, order = order)
        assertEquals(1200, discountMoney)
    }

    @Test
    fun `12월_25일_에는_3_400원을_활인_받는다`() {
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val orderFoods = listOf<OrderFood>(OrderFood(2, Food.Main.크리스마스파스타))
        val order: Order = Order.create(orderFoods)
        val discountMoney = christmasDiscountPolicy.discount(day = 25, order = order)
        assertEquals(3400, discountMoney)
    }

    @Test
    fun `25일_을_초과한_날은_크리스마스_할인을_받지_못한다`(){
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val orderFoods = listOf<OrderFood>(OrderFood(2, Food.Main.크리스마스파스타))
        val order: Order = Order.create(orderFoods)
        val discountMoney = christmasDiscountPolicy.discount(26, order)
        assertEquals(0, discountMoney)
    }
}