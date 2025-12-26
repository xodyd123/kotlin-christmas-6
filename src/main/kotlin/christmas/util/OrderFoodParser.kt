package christmas.util

import christmas.domain.menu.Food
import christmas.domain.order.OrderFood
import christmas.exception.ErrorMessage

object OrderFoodParser {

    private val foodByNames =
        buildList<Food> {
            addAll(Food.Appetizer.entries)
            addAll(Food.Dessert.entries)
            addAll(Food.Drink.entries)
            addAll(Food.Main.entries)
        }.associateBy { it.foodName }

    fun parseOrderFoods(input: String): List<OrderFood> {
        val foods: List<String> = input.trim().split(",")

        val orderFood: List<OrderFood> = foods.map { it ->
            val food: List<String> = it.split("-")
            require(food.size == 2) { ErrorMessage.INVALID_ORDER.formatted }
            val name = foodByNames[food[0]] ?: throw IllegalArgumentException(ErrorMessage.INVALID_ORDER.formatted)
            val quantity = food[1].toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.INVALID_ORDER.formatted)
            require(quantity > 0) { ErrorMessage.INVALID_ORDER.formatted }

            OrderFood(quantity, name)
        }
        return orderFood
    }
}