package christmas.domain.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class DayCalculatorTest {

    @ParameterizedTest(name = "days={0} -> 금요알")
    @ValueSource(ints = [1, 8, 15, 22, 29])
    fun `금요일은_주말로_계산한다`(day: Int) {
        val days = DayCalculator.calculate(day)
        assertEquals(Day.WEEKEND, days)
    }

    @ParameterizedTest(name = "days={0} -> 토요일")
    @ValueSource(ints = [2, 9, 16, 23, 30])
    fun `토요일은_주말로_계산한다`(day: Int) {
        val days = DayCalculator.calculate(day)
        assertEquals(Day.WEEKEND, days)
    }

    @ParameterizedTest(name = "days={0} -> 일요일")
    @ValueSource(ints = [3, 10, 17, 24, 31])
    fun `일요일은_평일로_계산한다`(day: Int) {
        val days = DayCalculator.calculate(day)
        assertEquals(Day.WEEKDAY, days)
    }

    @ParameterizedTest(name = "days={0} -> 월요일")
    @ValueSource(ints = [4, 11, 18, 25])
    fun `월요일은_평일로_계산한다`(day: Int) {
        val days = DayCalculator.calculate(day)
        assertEquals(Day.WEEKDAY, days)
    }

    @ParameterizedTest(name = "days={0} -> 화요일")
    @ValueSource(ints = [5, 12, 19, 26])
    fun `화요일은_평일로_계산한다`(day: Int) {
        val days = DayCalculator.calculate(day)
        assertEquals(Day.WEEKDAY, days)
    }

    @ParameterizedTest(name = "days={0} -> 수요일")
    @ValueSource(ints = [6, 13, 20, 27])
    fun `수요일은_평일로_계산한다`(day: Int) {
        val days = DayCalculator.calculate(day)
        assertEquals(Day.WEEKDAY, days)
    }

    @ParameterizedTest(name = "days={0} -> 목요일")
    @ValueSource(ints = [7, 14, 21, 28])
    fun `목요일은_평일로_계산한다`(day: Int) {
        val days = DayCalculator.calculate(day)
        assertEquals(Day.WEEKDAY, days)
    }

    @ParameterizedTest(name = "day={0} -> {1}")
    @CsvSource(
        "1, WEEKEND",
        "2, WEEKEND",
        "3, WEEKDAY",
        "4, WEEKDAY",
        "5, WEEKDAY",
        "6, WEEKDAY",
        "7, WEEKDAY",
        "8, WEEKEND"
    )
    fun `day는 WEEKDAY-WEEKEND로 계산된다`(day: Int, expected: Day) {
        assertEquals(expected, DayCalculator.calculate(day))
    }
}