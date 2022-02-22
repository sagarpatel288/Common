package com.example.android.common.learning.solid

data class HealthCustomer(
    val id: String,
    val firstName: String,
    val lastName: String,
    val streak: Long
): IsLoyal {
    override fun isLoyal(): Boolean {
        return streak >= 20
    }
}



