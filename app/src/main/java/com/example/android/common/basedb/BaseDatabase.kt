package com.example.android.common.basedb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.common.basedb.basedao.BaseDao
import com.example.android.common.basedb.basedao.CategoryDao
import com.example.android.common.basedb.basedao.ProductDao
import com.example.android.common.basedb.basedao.RankingDao
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.model.Product
import com.example.android.ecommerce.model.Ranking
import com.example.android.ecommerce.typeconverters.*

@Database(
    entities = [(Category::class), (Product::class), (Ranking::class)],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    CategoryListTypeConverter::class,
    ProductListTypeConverter::class,
    TaxListTypeConverter::class,
    VariantListTypeConverter::class,
    TaxTypeConverter::class,
    VariantTypeConverter::class,
    ChildCategoryListTypeConverter::class
)

abstract class BaseDatabase : RoomDatabase() {
    abstract fun <T> getBaseDao(t: T): BaseDao<T>
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getProductDao(): ProductDao
    abstract fun getRankingDao(): RankingDao
}