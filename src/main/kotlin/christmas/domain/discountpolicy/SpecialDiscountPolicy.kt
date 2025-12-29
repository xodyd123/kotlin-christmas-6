package christmas.domain.discountpolicy

import christmas.domain.discountpolicy.DiscountConstants.BASE_DISCOUNT
import christmas.domain.discountpolicy.DiscountConstants.NO_DISCOUNT
import christmas.domain.order.Day
import christmas.domain.order.Order

object SpecialDiscountPolicy : DiscountPolicy {

    private val specialDays =
        setOf<Day>(Day.parse("3"), Day.parse("10"), Day.parse("17"), Day.parse("24"), Day.parse("25"), Day.parse("31"))

    override fun discount(day: Day, order: Order): Int {
        if (specialDays.contains(day))
            return BASE_DISCOUNT

        return NO_DISCOUNT
    }
}