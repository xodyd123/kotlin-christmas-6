package christmas.service

data class ReserveResultDto(
    val day: Int,
    val orderAmount: Int,
    val orderFoods: List<OrderMenu>,
    val champagneGiftEligible: Boolean,
    val totalDiscountResult: List<DiscountEventDto>
)
