package christmas.domain.discountpolicy


interface DiscountPolicy {

    fun discount(day: Int): Int
}