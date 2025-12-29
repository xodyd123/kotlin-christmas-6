package christmas.domain.discountpolicy

import christmas.domain.order.Day
import christmas.domain.order.Order
import christmas.service.DiscountEventDto


interface DiscountPolicy {

    fun discount(day: Day, order: Order): Int

    fun discountResult(day: Day, order: Order): DiscountEventDto?
}