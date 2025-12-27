package christmas.domain.discountpolicy

import christmas.domain.discountpolicy.DiscountConstants.DAY_BASE_DISCOUNT
import christmas.domain.menu.Food
import christmas.domain.order.Order
import christmas.domain.order.OrderFood

object WeekDayDiscountPolicy : DiscountPolicy {

    override fun discount(day: Int, order: Order): Int {
        val dessertCount = order.orderFoods.sumOf { if (it.food is Food.Dessert) it.count else 0 }

        return dessertCount * DAY_BASE_DISCOUNT
    }
}