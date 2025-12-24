package christmas.domain.calculator

object DayCalculator {

    fun calculate(day: Int): DayType {
        val calculatedDay = day % 7
        return when (calculatedDay) {
            1 -> DayType.WEEKEND
            2 -> DayType.WEEKEND
            else -> {
                DayType.WEEKDAY
            }
        }
    }
}