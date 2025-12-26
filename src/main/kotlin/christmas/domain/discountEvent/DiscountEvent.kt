package christmas.domain.discountEvent

import christmas.domain.calculator.DayType
import christmas.domain.discountpolicy.ChristmasDiscountPolicy
import christmas.domain.discountpolicy.DiscountPolicy
import christmas.domain.discountpolicy.SpecialDiscountPolicy
import christmas.domain.discountpolicy.WeekDayDiscountPolicy
import christmas.domain.discountpolicy.WeekendDiscountPolicy
import christmas.domain.order.Day
import christmas.domain.order.Order

object DiscountEvent {
    private val datePolicies = listOf<DiscountPolicy>(ChristmasDiscountPolicy, SpecialDiscountPolicy)

    fun totalDiscount(day: Day, order: Order): Int {
        val dayTypeDiscount = when (day.classify()) {
            DayType.WEEKDAY -> WeekDayDiscountPolicy.discount(order.orderFoods)
            DayType.WEEKEND -> WeekendDiscountPolicy.discount(order.orderFoods)
        }
        val dateDiscount = datePolicies.sumOf { it.discount(day.dayOfMonth) }
        return dateDiscount + dayTypeDiscount
    }

}