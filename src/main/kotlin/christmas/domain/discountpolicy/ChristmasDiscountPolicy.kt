package christmas.domain.discountpolicy

import christmas.domain.discountpolicy.DiscountConstants.BASE_DISCOUNT
import christmas.domain.order.Day

object ChristmasDiscountPolicy : DiscountPolicy {

    private const val CHRISTMAS_DAY = 25
    private const val START_DAY = 1
    private const val DAILY_INCREASE = 100

    override fun discount(day: Int): Int {
        if (day > CHRISTMAS_DAY) {
            return DiscountConstants.NO_DISCOUNT
        }

        return BASE_DISCOUNT + (day - START_DAY) * DAILY_INCREASE
    }


}