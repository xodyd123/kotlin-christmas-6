package christmas.domain.discountPolicy

import christmas.domain.discountpolicy.WeekDayDiscountPolicy
import christmas.domain.menu.Food
import christmas.domain.order.OrderFood
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WeekDayDiscountPolicyTest {

    @Test
    fun 평일_에는_디저트_메뉴가_1개_있으면_1개_할인_받는다() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(2, Food.Appetizer.타파스),
            OrderFood(1, Food.Dessert.초코케이크),
            OrderFood(1, Food.Main.크리스마스파스타)
        )
        val weekDayDiscountMoney = WeekDayDiscountPolicy.discount(orderFoods)

        assertEquals(2023, weekDayDiscountMoney)

    }

    @Test
    fun 평일_에는_디저트_메뉴가_2개_있으면_2개_할인_받는다() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(2, Food.Appetizer.타파스),
            OrderFood(2, Food.Dessert.초코케이크),
            OrderFood(1, Food.Dessert.아이스크림),
            OrderFood(1, Food.Main.크리스마스파스타)
        )
        val weekDayDiscountMoney = WeekDayDiscountPolicy.discount(orderFoods)

        assertEquals(4046, weekDayDiscountMoney)

    }

    @Test
    fun 평일_에는_디저트_메뉴가_없으면_할인_받지_못한다() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(2, Food.Appetizer.타파스),
            OrderFood(1, Food.Drink.샴페인),
            OrderFood(1, Food.Drink.제로콜라),
            OrderFood(1, Food.Main.크리스마스파스타)
        )
        val weekDayDiscountMoney = WeekDayDiscountPolicy.discount(orderFoods)

        assertEquals(0, weekDayDiscountMoney)

    }

    @Test
    fun 평일_에는_동일한_디저트_메뉴가__각각_1개씩_있으면_1개만_할인_받는다() {
        val orderFoods = listOf<OrderFood>(
            OrderFood(2, Food.Appetizer.타파스),
            OrderFood(1, Food.Dessert.초코케이크),
            OrderFood(1, Food.Dessert.초코케이크),
            OrderFood(1, Food.Dessert.아이스크림),
            OrderFood(1, Food.Main.크리스마스파스타)
        )
        val weekDayDiscountMoney = WeekDayDiscountPolicy.discount(orderFoods)

        assertEquals(4046, weekDayDiscountMoney)

    }

    // 디저트 메뉴를 각각 1개씩 시켰을떄
    // 초코케이크 1개 , 초코케이크 1개

}