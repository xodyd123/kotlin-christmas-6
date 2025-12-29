package christmas.exception

enum class ErrorMessage(private val message: String) {
    INVALID_DAY_NUMBER("유효하지 않은 날짜입니다. "),
    INVALID_ORDER("유효하지 않은 주문입니다. ");


    companion object {
        private const val PREFIX = "[ERROR]"
        private const val POSTFIX = "다시 입력해 주세요."
    }

    val formatted: String
        get() = "$PREFIX $message$POSTFIX"


}
