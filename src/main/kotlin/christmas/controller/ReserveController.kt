package christmas.controller

import christmas.domain.discountEvent.DiscountEvent
import christmas.domain.order.Day
import christmas.domain.order.Order
import christmas.domain.order.OrderFood
import christmas.service.ReserveResultDto
import christmas.service.ReserveService
import christmas.util.OrderFoodParser
import christmas.view.InputView
import christmas.view.OutputView

class ReserveController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val reserveService: ReserveService
) {
    fun start() {

        outputView.printStartPrompt()
        val day: Day = readDayValid()
        outputView.printOrderPrompt()
        val orderFood: List<OrderFood> = readOrderMenu()
        val order: Order = Order.create(orderFood)
        val reserve: ReserveResultDto = reserveService.reserve(day, order)
        outputView.reserveResult(reserve)
    }

    private fun readDayValid(): Day {

        while (true) {
            val inputs: String = inputView.read()
            try {
                return Day.parse(inputs)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readOrderMenu(): List<OrderFood> {

        while (true) {
            val inputs = inputView.read()
            try {
                return OrderFoodParser.parseOrderFoods(inputs)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}