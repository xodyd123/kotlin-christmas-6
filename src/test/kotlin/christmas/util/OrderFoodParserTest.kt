package christmas.util

import christmas.exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OrderFoodParserTest {

    @ParameterizedTest(name = "메뉴판에 없는 메뉴={0}")
    @ValueSource(strings = ["바닐라아이스크림-1", "망고빙수-1"])
    fun `메뉴판에_없는_메뉴는_예외가_발생`(foodName: String) {
        val ex = assertThrows<IllegalArgumentException> { OrderFoodParser.parseOrderFoods(foodName) }
        assertEquals(ErrorMessage.INVALID_ORDER.formatted, ex.message)

    }

    @ParameterizedTest(name = "메뉴판에 있는 메뉴={0}")
    @ValueSource(strings = ["제로콜라-1", "아이스크림-1"])
    fun `메뉴판에_있는_메뉴는_정상_작동`(foodName: String) {
        assertDoesNotThrow { OrderFoodParser.parseOrderFoods(foodName) }

    }

    @ParameterizedTest(name = "메뉴에 갯수가 1이상이 아닐경우={0}")
    @ValueSource(strings = ["초코케이크-0", "제로콜라--1", "아이스크림-ㄹ", "아이스크림-"])
    fun `메뉴에_갯수가_1이상이_아닐때`(foodName: String) {
        val ex = assertThrows<IllegalArgumentException> { OrderFoodParser.parseOrderFoods(foodName) }
        assertEquals(ErrorMessage.INVALID_ORDER.formatted, ex.message)
    }

    @ParameterizedTest(name = "메뉴 2개이상 주문했을때 예와가 발생 할 경우={0}")
    @ValueSource(strings = ["초코케이크-1,제로콜라-,아이스크림-1", "초코케이크--1,제로콜라-1,아이스크림-1", "티본스테이크-1-2,바비큐립-1"])
    fun `메뉴_2개이상_주문했을때_예외가_발생_할_경우`(foodName: String) {
        val ex = assertThrows<IllegalArgumentException> { OrderFoodParser.parseOrderFoods(foodName) }
        assertEquals(ErrorMessage.INVALID_ORDER.formatted, ex.message)
    }

    @ParameterizedTest(name = "메뉴 2개이상 주문했을때 정상 실행 할 경우={0}")
    @ValueSource(strings = ["초코케이크-1,제로콜라-1,아이스크림-1", "티본스테이크-1,바비큐립-1"])
    fun `메뉴_2개이상_주문했을때_정상_실행_할_경우`(foodName: String) {
        assertDoesNotThrow{ OrderFoodParser.parseOrderFoods(foodName) }
    }

    @Test
    fun `중복_메뉴_일경우_예외_발생한다`() {
        val ex = assertThrows<IllegalArgumentException> { OrderFoodParser.parseOrderFoods("시저샐러드-1,시저샐러드-1") }
        assertEquals(ErrorMessage.INVALID_ORDER.formatted, ex.message)
    }


}