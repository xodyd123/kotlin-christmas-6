package christmas.domain.discountPolicy

import christmas.domain.discountpolicy.ChristmasDiscountPolicy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ChristmasDiscountPolicyTest {

    @Test
    fun `12월_1일_에는_1_000원을_활인_받는다`() {
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val discountMoney = christmasDiscountPolicy.discount(1)
        assertEquals(1000, discountMoney)
    }

    @Test
    fun `12월_2일_에는_1_100원을_활인_받는다`() {
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val discountMoney = christmasDiscountPolicy.discount(2)
        assertEquals(1100, discountMoney)
    }

    @Test
    fun `12월_3일_에는_1_200원을_활인_받는다`() {
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val discountMoney = christmasDiscountPolicy.discount(3)
        assertEquals(1200, discountMoney)
    }

    @Test
    fun `12월_25일_에는_3_400원을_활인_받는다`() {
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val discountMoney = christmasDiscountPolicy.discount(25)
        assertEquals(3400, discountMoney)
    }

    @Test
    fun `25일_을_초과한_날은_크리스마스_할인을_받지_못한다`(){
        val christmasDiscountPolicy = ChristmasDiscountPolicy
        val discountMoney = christmasDiscountPolicy.discount(26)
        assertEquals(0, discountMoney)
    }
}