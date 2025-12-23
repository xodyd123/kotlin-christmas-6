package christmas.domain.discountPolicy

import christmas.domain.discountpolicy.WeekendDiscountPolicy
import christmas.domain.menu.Food
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
        val weekDayDiscountMoney = WeekendDiscountPolicy.discount(orderFoods)

        assertEquals(2023, weekDayDiscountMoney)

    }

    @Test
    fun 평일_에는_디저트_메뉴가_2개_있으면_2개_할인_받는다() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(2, Food.Appetizer.타파스),
            OrderFood(2, Food.Dessert.초코케이크),
            OrderFood(1, Food.Dessert.아이스크림),
            OrderFood(1, Food.Main.크리스마스파스타),
            OrderFood(1, Food.Main.바비큐립)
        )
        val weekDayDiscountMoney = WeekendDiscountPolicy.discount(orderFoods)

        assertEquals(4046, weekDayDiscountMoney)

    }

    @Test
    fun 평일_에는_디저트_메뉴가_없으면_할인_받지_못한다() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(2, Food.Appetizer.타파스),
            OrderFood(1, Food.Drink.샴페인),
            OrderFood(1, Food.Drink.제로콜라),
        )
        val weekDayDiscountMoney = WeekendDiscountPolicy.discount(orderFoods)

        assertEquals(0, weekDayDiscountMoney)

    }
}