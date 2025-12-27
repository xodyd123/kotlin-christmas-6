package christmas.domain.discountpolicy

import christmas.domain.discountpolicy.DiscountConstants.BASE_DISCOUNT
import christmas.domain.discountpolicy.DiscountConstants.NO_DISCOUNT
import christmas.domain.order.Order

object SpecialDiscountPolicy : DiscountPolicy {

    private val specialDays = setOf<Int>(3, 10, 17, 24, 25, 31)

    override fun discount(day: Int, order: Order): Int {
        if (specialDays.contains(day))
            return BASE_DISCOUNT

        return NO_DISCOUNT
    }
}