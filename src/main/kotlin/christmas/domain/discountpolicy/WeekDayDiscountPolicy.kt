package christmas.domain.discountpolicy

import christmas.domain.calculator.DayType
import christmas.domain.discountpolicy.DiscountConstants.DAY_BASE_DISCOUNT
import christmas.domain.menu.Food
import christmas.domain.order.Day
import christmas.domain.order.Order

object WeekDayDiscountPolicy : DiscountPolicy {

    override fun discount(day: Day, order: Order): Int {
        if (day.classify() != DayType.WEEKDAY) return 0

        val dessertCount = order.orderFoods.sumOf { if (it.food is Food.Dessert) it.count else 0 }
        return dessertCount * DAY_BASE_DISCOUNT
    }
}