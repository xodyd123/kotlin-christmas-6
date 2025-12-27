package christmas.domain.discountEvent

import christmas.domain.discountpolicy.ChristmasDiscountPolicy
import christmas.domain.discountpolicy.DiscountPolicy
import christmas.domain.discountpolicy.SpecialDiscountPolicy
import christmas.domain.discountpolicy.WeekDayDiscountPolicy
import christmas.domain.discountpolicy.WeekendDiscountPolicy
import christmas.domain.order.Day
import christmas.domain.order.Order

object DiscountEvent {
    private val datePolicies = listOf<DiscountPolicy>(
        ChristmasDiscountPolicy, SpecialDiscountPolicy,
        WeekendDiscountPolicy, WeekDayDiscountPolicy
    )

    fun totalDiscount(day: Day, order: Order): Int {
        val discount = datePolicies.sumOf { it.discount(day, order) }
        return discount
    }

}