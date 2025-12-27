package christmas.domain.discountPolicy

import christmas.domain.discountpolicy.WeekDayDiscountPolicy
import christmas.domain.discountpolicy.WeekendDiscountPolicy
import christmas.domain.menu.Food
import christmas.domain.order.Order
import christmas.domain.order.OrderFood
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WeekendDiscountPolicyTest {

    @Test
    fun 주말_에는_메인_메뉴가_1개_있으면_1개_할인_받는다() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(2, Food.Appetizer.타파스),
            OrderFood(1, Food.Dessert.초코케이크),
            OrderFood(1, Food.Main.크리스마스파스타)
        )
        val order = Order.create(orderFoods)

        val weekDayDiscountMoney = WeekendDiscountPolicy.discount(2, order)

        assertEquals(2023, weekDayDiscountMoney)

    }


    @Test
    fun 주말_에는_동일한_메인_메뉴가__각각_1개씩_있으면_1개씩_할인_받는다() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(2, Food.Appetizer.타파스),
            OrderFood(1, Food.Dessert.아이스크림),
            OrderFood(1, Food.Main.크리스마스파스타),
            OrderFood(1, Food.Main.티본스테이크)
        )
        val order = Order.create(orderFoods)
        val weekDayDiscountMoney = WeekendDiscountPolicy.discount(2, order)

        assertEquals(4046, weekDayDiscountMoney)

    }

}