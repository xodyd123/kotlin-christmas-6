package christmas.domain.discountpolicy

import christmas.domain.discountpolicy.DiscountConstants.DAY_BASE_DISCOUNT
import christmas.domain.menu.Food
import christmas.domain.order.OrderFood

object WeekDayDiscountPolicy : DayDiscountPolicy {

    override fun discount(orderFood: List<OrderFood>): Int {
        val dessertCount = orderFood.sumOf { if(it.food is Food.Dessert) it.count else 0 }

        return dessertCount * DAY_BASE_DISCOUNT
    }
}