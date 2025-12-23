package christmas.domain.order

class Order(private vararg val orderFoods: OrderFood) {

    fun isChampagneGiftEligible(): Boolean {
        val total = orderFoods.toList().sumOf { orderFood -> orderFood.food.price * orderFood.count }
        return total >= 120_000
    }
}