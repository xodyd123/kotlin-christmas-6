package christmas.domain.order

import christmas.exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DayTest {

    private fun assertInvalid(input: String) {
        val ex = assertThrows<IllegalArgumentException> { Day.parse(input) }
        assertEquals(ErrorMessage.INVALID_DAY_NUMBER.formatted, ex.message)
    }

    @ParameterizedTest(name = "숫자가 아닌문자 :{0}")
    @ValueSource(strings = ["t", "1t", "tt"])
    fun `숫자로_변환할수_없는_문자는_예외가_발생한다`(input: String) {

        assertInvalid(input)
    }

    @ParameterizedTest(name = "공백 문자 :{0}")
    @ValueSource(strings = ["", " "])
    fun `공백인_문자는_예외가_발생한다`(input: String) {

        assertInvalid(input)
    }

    @ParameterizedTest(name = "1,31 범위 안에 있지 않은 숫자 :{0}")
    @ValueSource(strings = ["-1", "0", "32", "100"])
    fun `범위안에_있지않는_숫자_문자열은_예외가_발생한다`(input: String) {

        assertInvalid(input)
    }

    @ParameterizedTest(name = "1,31 범위 안에 있는 숫자 :{0}")
    @ValueSource(strings = ["1", "2", "31", "10"])
    fun `범위안에_있는_숫자_문자열은_정상_실행된다`(input: String) {
        assertDoesNotThrow { Day.parse(input) }
    }


}