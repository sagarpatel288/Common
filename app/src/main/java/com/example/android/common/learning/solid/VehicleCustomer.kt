package com.example.android.common.learning.solid

data class VehicleCustomer(
    val id: String,
    val firstName: String,
    val lastName: String,
    var streak: Int
): IsLoyal {
    override fun isLoyal(): Boolean {
        return streak >= 10
    }
}

