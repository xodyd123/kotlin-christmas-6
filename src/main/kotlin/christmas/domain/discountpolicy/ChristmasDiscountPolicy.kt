package christmas.domain.discountpolicy

import christmas.domain.discountpolicy.DiscountConstants.BASE_DISCOUNT
import christmas.domain.order.Day
import christmas.domain.order.Order
import christmas.service.DiscountEventDto
import christmas.service.Event

object ChristmasDiscountPolicy : DiscountPolicy {

    private const val CHRISTMAS_DAY = 25
    private const val START_DAY = 1
    private const val DAILY_INCREASE = 100

    override fun discount(day: Day, order: Order): Int {
        if (day.dayOfMonth > CHRISTMAS_DAY) {
            return DiscountConstants.NO_DISCOUNT
        }

        return BASE_DISCOUNT + (day.dayOfMonth - START_DAY) * DAILY_INCREASE
    }

    override fun discountResult(
        day: Day,
        order: Order
    ): DiscountEventDto? {

        if (day.dayOfMonth > CHRISTMAS_DAY) {
            return null
        }

        val discountPrice: Int = -(BASE_DISCOUNT + (day.dayOfMonth - START_DAY) * DAILY_INCREASE)
        return DiscountEventDto(Event.CHRISTMAS, discountPrice)
    }

}