package christmas.domain.discountpolicy

import christmas.domain.calculator.DayType
import christmas.domain.discountpolicy.DiscountConstants.DAY_BASE_DISCOUNT
import christmas.domain.menu.Food
import christmas.domain.order.Day
import christmas.domain.order.Order
import christmas.service.DiscountEventDto
import christmas.service.Event

object WeekendDiscountPolicy : DiscountPolicy {

    override fun discount(day: Day, order: Order): Int {
        if (day.classify() != DayType.WEEKEND || day.dayOfMonth > 25) return 0
        val mainCount = order.orderFoods.count { orderFood -> orderFood.food is Food.Main }
        return mainCount * DAY_BASE_DISCOUNT
    }

    override fun discountResult(
        day: Day,
        order: Order
    ): DiscountEventDto? {
        if (day.classify() != DayType.WEEKEND || day.dayOfMonth > 25) return null
        val mainCount = order.orderFoods.count { orderFood -> orderFood.food is Food.Main }
        return DiscountEventDto(Event.WEEKEND, -(mainCount * DAY_BASE_DISCOUNT))
    }
}