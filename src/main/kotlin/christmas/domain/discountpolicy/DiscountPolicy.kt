package christmas.domain.discountpolicy

import christmas.domain.order.Day
import christmas.domain.order.Order


interface DiscountPolicy {

    fun discount(day: Day, order: Order): Int
}