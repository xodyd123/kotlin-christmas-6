package christmas.domain.calculator

object DayTypeClassifier {

    private const val DAYS_IN_WEEK = 7

    fun classify(dayOfMonth: Int): DayType {
        return when (dayOfMonth % DAYS_IN_WEEK) {
            1, 2 -> DayType.WEEKEND
            else -> {
                DayType.WEEKDAY
            }
        }
    }
}