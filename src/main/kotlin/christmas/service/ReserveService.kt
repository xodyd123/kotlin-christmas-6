package christmas.service

import christmas.domain.discountEvent.DiscountEvent
import christmas.domain.order.Day
import christmas.domain.order.Order

class ReserveService {

    fun reserve(inputDay: Day, order: Order): ReserveResultDto {
        val day = inputDay.dayOfMonth
        val orderAmount: Int = order.amount
        val orderFoods: List<OrderMenu> = order.ordersMenu
        val champagneGiftEligible: Boolean = order.isChampagneGiftEligible()
        val totalDiscountResult: List<DiscountEventDto> = DiscountEvent.totalDiscountResult(inputDay, order).filterNotNull()
        return ReserveResultDto(day, orderAmount, orderFoods, champagneGiftEligible, totalDiscountResult)
    }
}