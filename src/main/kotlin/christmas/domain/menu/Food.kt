package christmas.domain.menu

sealed interface Food {

    val price: Int

    enum class Appetizer(override val price: Int) : Food {
        양송이스프(6_000), 타파스(5_500), 시저샐러드(8_000)
    }

    enum class Main(override val price: Int) : Food {
        티본스테이크(55_000),
        바비큐립(54_000),
        해산물파스타(35_000),
        크리스마스파스타(25_000)
    }

    enum class Dessert(override val price: Int) : Food {
        초코케이크(15_000), 아이스크림(5_000)
    }

    enum class Drink(override val price: Int) : Food {
        제로콜라(3_000), 레드와인(60_000), 샴페인(25_000)
    }

}