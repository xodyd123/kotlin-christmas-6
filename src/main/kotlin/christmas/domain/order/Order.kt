package christmas.domain.order

import christmas.domain.menu.Food
import christmas.exception.ErrorMessage


@JvmInline
value class Order private constructor(private val orderFoods: List<OrderFood>) {

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