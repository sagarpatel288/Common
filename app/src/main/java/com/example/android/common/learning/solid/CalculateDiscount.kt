package com.example.android.common.learning.solid

class CalculateDiscount {
    fun calculateDiscount(customer: IsLoyal): Int {
        return if (customer.isLoyal()) 20 else 0
    }
}



