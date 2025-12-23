package christmas.domain.discountPolicy

import christmas.domain.discountpolicy.SpecialDiscountPolicy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

object SpecialDiscountPolicyTest {

    @ParameterizedTest(name = "days={0} -> 1000")
    @ValueSource(ints = [3, 10, 17, 24, 25, 31])
    fun `3,10,17,24,25,31일에는_1000원_특별_할인을_받는다`(day: Int) {
        val discountMoney = SpecialDiscountPolicy.discount(day)
        assertEquals(1000, discountMoney)
    }
}