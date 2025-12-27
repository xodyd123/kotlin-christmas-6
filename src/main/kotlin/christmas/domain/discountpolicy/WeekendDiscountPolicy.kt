package christmas.domain.discountpolicy

import christmas.domain.discountpolicy.DiscountConstants.DAY_BASE_DISCOUNT
import christmas.domain.menu.Food
import christmas.domain.order.Day
import christmas.domain.order.Order
import christmas.domain.order.OrderFood

object WeekendDiscountPolicy : DiscountPolicy {

    override fun discount(day: Int, order: Order): Int {
        val mainCount = order.orderFoods.count { orderFood -> orderFood.food is Food.Main }
        return mainCount * DAY_BASE_DISCOUNT
    }
}