package christmas.domain.discountpolicy

object ChristmasDiscountPolicy {

    private const val ONE_DAY = 1

    fun discount(day: Int): Int {

        if (day > 25) {
            return 0
        }

        return 1000 + (day - ONE_DAY) * 100
    }


}