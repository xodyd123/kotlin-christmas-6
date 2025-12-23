package christmas.domain.discountpolicy

import christmas.domain.discountpolicy.DiscountConstants.DAY_BASE_DISCOUNT
import christmas.domain.menu.Food
import christmas.domain.order.OrderFood

object WeekDayDiscountPolicy : DayDiscountPolicy {

    override fun discount(orderFood: List<OrderFood>): Int {
        val dessertCount = orderFood.count { orderFood -> orderFood.food is Food.Dessert }
        return dessertCount * DAY_BASE_DISCOUNT
    }
}