package christmas.domain.calculator

object DayCalculator {

    fun calculate(day: Int): Day {
        val calculatedDay = day % 7
        return when (calculatedDay) {
            1 -> Day.WEEKEND
            2 -> Day.WEEKEND
            else -> {
                Day.WEEKDAY
            }
        }
    }
}