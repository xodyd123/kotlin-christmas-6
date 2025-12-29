package christmas.domain.discountpolicy

import christmas.domain.calculator.DayType
import christmas.domain.discountpolicy.DiscountConstants.DAY_BASE_DISCOUNT
import christmas.domain.menu.Food
import christmas.domain.order.Day
import christmas.domain.order.Order
import christmas.service.DiscountEventDto
import christmas.service.Event

object WeekDayDiscountPolicy : DiscountPolicy {

    override fun discount(day: Day, order: Order): Int {
        if (day.classify() != DayType.WEEKDAY || day.dayOfMonth > 25) return 0

        val dessertCount = order.orderFoods.sumOf { if (it.food is Food.Dessert) it.count else 0 }
        return dessertCount * DAY_BASE_DISCOUNT
    }

    override fun discountResult(
        day: Day,
        order: Order
    ): DiscountEventDto? {
        if (day.classify() != DayType.WEEKDAY || day.dayOfMonth > 25) return null

        val dessertCount = order.orderFoods.sumOf { if (it.food is Food.Dessert) it.count else 0 }
        return DiscountEventDto(Event.WEEKDAY, -(dessertCount * DAY_BASE_DISCOUNT))
    }
}