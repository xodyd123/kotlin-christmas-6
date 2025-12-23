package christmas.domain.discountpolicy

import christmas.domain.discountpolicy.DiscountConstants.DAY_BASE_DISCOUNT
import christmas.domain.menu.Food
import christmas.domain.order.OrderFood

object WeekendDiscountPolicy : DayDiscountPolicy {

    override fun discount(orderFood: List<OrderFood>): Int {
        val mainCount = orderFood.count { orderFood -> orderFood.food is Food.Main }
        return mainCount * DAY_BASE_DISCOUNT
    }
}