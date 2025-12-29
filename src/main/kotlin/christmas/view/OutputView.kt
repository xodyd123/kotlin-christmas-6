package christmas.view

import christmas.service.DiscountEventDto
import christmas.service.Event
import christmas.service.OrderMenu
import christmas.service.ReserveResultDto
import java.util.Locale
import kotlin.math.abs

object OutputView {

    private const val START_PROMPT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
            "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"

    private const val ORDER_MENU_PROMPT = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"


    fun printStartPrompt() {
        println(START_PROMPT)
    }

    fun printOrderPrompt() {
        println(ORDER_MENU_PROMPT)
    }

    fun reserveResult(reserveResultDto: ReserveResultDto) {
        promptEvent(reserveResultDto.day)
        orderMenu(reserveResultDto.orderFoods)
        orderAmount(reserveResultDto.orderAmount)
        giftMenu(reserveResultDto.champagneGiftEligible)
        giftResult(reserveResultDto.totalDiscountResult, reserveResultDto.champagneGiftEligible)
        discountAmount(reserveResultDto.totalDiscountResult, reserveResultDto.champagneGiftEligible)
        afterDiscountPayAmount(reserveResultDto.orderAmount, reserveResultDto.totalDiscountResult)
        printEventBadge(reserveResultDto.totalDiscountResult, reserveResultDto.champagneGiftEligible)
    }

    private fun promptEvent(day: Int) {
        println("12월 ${day}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
        println()
    }

    private fun orderMenu(orderMenu: List<OrderMenu>) {
        println("<주문 메뉴>")
        var result = ""
        orderMenu.forEach { it ->
            result += "${it.foodName} ${it.count}개" + "\n"
        }
        println(result)
    }

    private fun orderAmount(amount: Int) {
        println("<할인 전 총주문 금액>")
        val convertAmount: String = convertString(amount)
        println("$convertAmount")
        println()
    }

    private fun giftMenu(boolean: Boolean) {
        println("<증정 메뉴>")
        when (boolean) {
            true -> println("샴페인 1개")
            false -> println("없음")
        }
        println()
    }

    private fun giftResult(totalDiscountResult: List<DiscountEventDto>, boolean: Boolean) {
        println("<혜택 내역>")

        if (totalDiscountResult.size > 1) {
            totalDiscountResult.forEach { it ->
                val money = convertString(it.discount)
                when (it.event) {
                    Event.CHRISTMAS -> println("크리스마스 디데이 할인: $money")
                    Event.WEEKDAY -> println("평일 할인: $money")
                    Event.WEEKEND -> println("주말 할인: $money")
                    Event.SPECIAL -> println("특별 할인: $money")
                }
            }
        } else {
            println("없음")
        }

        if (boolean) {
            println("증정 이벤트: -25,000원")
        }
        println()
    }

    private fun discountAmount(totalDiscountResult: List<DiscountEventDto>, boolean: Boolean) {
        println("<총혜택 금액>")
        var sum = totalDiscountResult.sumOf { it.discount }

        if (boolean) {
            sum -= 2_5000
        }
        val convertSum: String = convertString(sum)
        println("$convertSum")
        println()
    }

    private fun afterDiscountPayAmount(beforeAmount: Int, totalDiscountResult: List<DiscountEventDto>) {
        println("<할인 후 예상 결제 금액>")
        var result = beforeAmount
        val discountAmount = totalDiscountResult.sumOf { it.discount }
        val convertAmount: String = convertString(discountAmount)
        println("$convertAmount")
        println()
    }

    private fun printEventBadge(totalDiscountResult: List<DiscountEventDto>, boolean: Boolean) {
        println("<12월 이벤트 배지>")
        var sum = totalDiscountResult.sumOf { it.discount }

        if (boolean) {
            sum -= 2_5000
        }

        sum = abs(sum)

        if (sum >= 2_0000) {
            println("산타")
        } else if (sum >= 1_0000) {
            println("트리")
        } else if (sum >= 5_000) {
            println("별")
        } else {
            println("없음")
        }
    }

    fun convertString(money: Int): String {
        return String.format(Locale.KOREA, "%,d원", money)
    }


}