package christmas.domain.discountpolicy

import christmas.domain.order.OrderFood

interface DayDiscountPolicy {

    fun discount(orderFood: List<OrderFood>): Int
}