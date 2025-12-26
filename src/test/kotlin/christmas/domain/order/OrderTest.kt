package christmas.domain.order

import christmas.domain.menu.Food
import christmas.exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class OrderTest {

    @Test
    fun `할인_전_총_주문_금액이_12만원_이상일_때_샴페인_증정_대상이다`() {
        val orderFood1 = OrderFood(2, Food.Main.티본스테이크)
        val orderFood2 = OrderFood(2, Food.Appetizer.타파스) // 총 121,000

        val order = Order.create(listOf(orderFood1, orderFood2))
        assertTrue(order.isChampagneGiftEligible())

    }

    @Test
    fun `할인_전_총_주문_금액이_12만원_미만이면_샴페인_증정_대상이_아니다`() {

        val order = Order.create(listOf(OrderFood(2, Food.Main.크리스마스파스타), OrderFood(1, Food.Drink.레드와인)))

        assertFalse(order.isChampagneGiftEligible())
    }

    @Test
    fun `음료만_주문시_주문_할수_없다`() {

        val exception: IllegalArgumentException = assertThrows<IllegalArgumentException> {
            Order.create(
                listOf(OrderFood(1, Food.Drink.제로콜라), OrderFood(1, Food.Drink.레드와인))
            )
        }

        assertEquals(ErrorMessage.INVALID_ORDER.formatted, exception.message)
    }

    @Test
    fun `메뉴는_한_번에_최대_20개까지만_주문할_수_있다`() {

        assertDoesNotThrow {
            Order.create(
                listOf(
                    OrderFood(10, Food.Drink.제로콜라),
                    OrderFood(5, Food.Main.크리스마스파스타),
                    OrderFood(5, Food.Appetizer.타파스)
                )
            )
        }
    }


    @Test
    fun `메뉴는_한_번에_20개_초과_주문하면_예외가_발생`() {

        val exception: IllegalArgumentException = assertThrows<IllegalArgumentException> {
            Order.create(
                listOf(OrderFood(10, Food.Drink.제로콜라), OrderFood(11, Food.Main.크리스마스파스타))
            )
        }

        assertEquals(ErrorMessage.INVALID_ORDER.formatted, exception.message)
    }

    @Test
    fun `총_주문_금액이_10,000원_이상부터_할인_이벤트가_적용되지_않는다`() {
        val order = Order.create(listOf(OrderFood(1, Food.Appetizer.타파스), OrderFood(1, Food.Drink.제로콜라)))
        val isDiscountable = order.isDiscountable
        assertFalse(isDiscountable)
        assertEquals(8500, order.amount)
    }

    @Test
    fun `총_주문_금액이_10,000원_이상부터_할인_이벤트가_적용된다`() {
        val order = Order.create(listOf(OrderFood(2, Food.Appetizer.타파스)))
        val isDiscountable = order.isDiscountable
        assertTrue(isDiscountable)
        assertEquals(11_000, order.amount)
    }

    @Test
    fun `총_주문_금액이_정확히_10,000원일떄_할인_이벤트가_적용된다`() {
        val order = Order.create(listOf(OrderFood(2, Food.Dessert.아이스크림)))
        val isDiscountable = order.isDiscountable
        assertTrue(isDiscountable)
        assertEquals(10_000, order.amount)
    }


}