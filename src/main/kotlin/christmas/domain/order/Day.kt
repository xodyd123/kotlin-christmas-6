package christmas.domain.order

import christmas.exception.ErrorMessage

@JvmInline
value class Day private constructor(private val dayOfMonth: Int) {

    init {
        require(dayOfMonth in 1..31) { ErrorMessage.INVALID_DAY_NUMBER.formatted }
    }

    companion object {
        fun parse(input: String): Day {
            val value = input.trim().toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.INVALID_DAY_NUMBER.formatted)
            return Day(value)
        }
    }

}