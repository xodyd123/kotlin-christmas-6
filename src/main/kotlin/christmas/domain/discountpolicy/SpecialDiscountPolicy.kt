package christmas.domain.discountpolicy

object SpecialDiscountPolicy : DiscountPolicy {

    private val specialDays = setOf<Int>(3, 10, 17, 24, 25, 31)

    override fun discount(day: Int): Int {
        if (specialDays.contains(day))
            return 1000

        return 0
    }
}