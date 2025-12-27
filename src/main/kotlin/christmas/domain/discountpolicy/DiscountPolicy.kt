package christmas.domain.discountpolicy

import christmas.domain.order.Order


interface DiscountPolicy {

    fun discount(day: Int, order: Order): Int
}