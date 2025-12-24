package christmas.exception

enum class ErrorMessage(private val message: String) {
    INVALID_DAY_NUMBER("유효하지 않은 날짜입니다");

    companion object {
        private const val PREFIX = "[ERROR]"
    }

    val formatted: String
        get() = "$PREFIX $message"


}
