package christmas.domain.menu

sealed interface Food {

    val price: Int

    val foodName: String

    enum class Appetizer(override val price: Int, override val foodName: String) : Food {
        양송이스프(6_000, "양송이스프"), 타파스(5_500, "타파스"), 시저샐러드(8_000, "시저샐러드")
    }

    enum class Main(override val price: Int, override val foodName: String) : Food {
        티본스테이크(55_000, "티본스테이크"),
        바비큐립(54_000, "바비큐립"),
        해산물파스타(35_000, "해산물파스타"),
        크리스마스파스타(25_000, "크리스마스파스타")
    }

    enum class Dessert(override val price: Int, override val foodName: String) : Food {
        초코케이크(15_000, "초코케이크"), 아이스크림(5_000, "아이스크림")
    }

    enum class Drink(override val price: Int , override val foodName: String) : Food {
        제로콜라(3_000, "제로콜라"), 레드와인(60_000, "레드와인"), 샴페인(25_000, "샴페인")
    }

}