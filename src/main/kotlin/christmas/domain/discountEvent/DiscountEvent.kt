package christmas.domain.discountEvent

import christmas.domain.discountpolicy.ChristmasDiscountPolicy
import christmas.domain.discountpolicy.DiscountPolicy
import christmas.domain.discountpolicy.SpecialDiscountPolicy
import christmas.domain.discountpolicy.WeekDayDiscountPolicy
import christmas.domain.discountpolicy.WeekendDiscountPolicy
import christmas.domain.order.Day
import christmas.domain.order.Order
import christmas.service.DiscountEventDto

object DiscountEvent {
    private val datePolicies = listOf<DiscountPolicy>(
        ChristmasDiscountPolicy,
        WeekendDiscountPolicy,
        WeekDayDiscountPolicy,
        SpecialDiscountPolicy,
    )

    fun totalDiscount(day: Day, order: Order): Int {
        val discount = datePolicies.sumOf { it.discount(day, order) }
        return discount
    }

    fun totalDiscountResult(day: Day, order: Order): List<DiscountEventDto?> {
        val discountResult = datePolicies.map { it.discountResult(day, order) }
        return discountResult
    }

}