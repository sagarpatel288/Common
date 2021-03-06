package com.example.android.ecommerce.model


import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.android.ecommerce.typeconverters.ProductListTypeConverter
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@SuppressLint("ParcelCreator")
@Parcelize
data class Ranking(
    @PrimaryKey(autoGenerate = true)
    var primaryKey: Long = 0,
    @TypeConverters(ProductListTypeConverter::class)
    @SerializedName("products")
    var products: List<Product>? = null,
    @SerializedName("ranking")
    var ranking: String? = null // Most ShaRed Products
) : Parcelable