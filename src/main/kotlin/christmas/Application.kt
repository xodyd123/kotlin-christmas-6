package christmas

import christmas.controller.ReserveController
import christmas.service.ReserveService
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val reserveController: ReserveController = ReserveController(InputView, OutputView, ReserveService())
    reserveController.start()
}
