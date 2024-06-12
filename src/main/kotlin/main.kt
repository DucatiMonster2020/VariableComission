import kotlin.math.max

fun main() {
    val totalComission = comission("MasterCard", 1000, amount = 150000)
    println(totalComission)
}
    const val ERROR_LIMIT = -1
    const val MASTER_LIMIT = 75_000 //месячный беспроцентный лимит по данной карте
    const val LIMIT_DAILY = 150_000
    const val LIMIT_MONTHLY = 600_000

fun comission(typeCard: String = "Mir", previous: Int = 0, amount: Int): Double {
    if (amount > LIMIT_DAILY || amount + previous > LIMIT_MONTHLY) return ERROR_LIMIT.toDouble()
    return when (typeCard) {
        "MasterCard" -> if (amount + previous > MASTER_LIMIT.toDouble()) return ((amount + previous) - MASTER_LIMIT) * 0.006 + 20 else 0.0
        "Visa" -> max(35.0, (amount * 0.0075))
        else -> 0.0
    }
}
