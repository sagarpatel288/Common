package com.example.android.common.learning.solid

data class HomeCustomer(
    val id: String,
    val firstName: String,
    val lastName: String,
    val streak: Int
) : IsLoyal {
    override fun isLoyal(): Boolean {
        return streak >= 5
    }
}

