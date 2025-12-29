package christmas.domain.order

import christmas.domain.menu.Food
import christmas.exception.ErrorMessage
import christmas.service.OrderMenu


@JvmInline
value class Order private constructor(val orderFoods: List<OrderFood>) {

    val amount: Int
        get() = orderFoods.sumOf { orderFood -> orderFood.food.price * orderFood.count }

    val isDiscountable: Boolean
        get() = amount >= 10000

    val ordersMenu: List<OrderMenu>
        get() = orderFoods.map { orderFood -> OrderMenu(orderFood.count, orderFood.food.foodName) }


    init {
        require(orderFoods.any { orderFood -> orderFood.food !is Food.Drink }) { ErrorMessage.INVALID_ORDER.formatted }
        require(orderFoods.sumOf { orderFood -> orderFood.count } <= 20) { ErrorMessage.INVALID_ORDER.formatted }
    }

    companion object {
        fun create(orderFoods: List<OrderFood>): Order {
            return Order(orderFoods.toList())
        }
    }

    fun isChampagneGiftEligible(): Boolean {
        val total = orderFoods.sumOf { orderFood -> orderFood.food.price * orderFood.count }
        return total >= 120_000
    }
}