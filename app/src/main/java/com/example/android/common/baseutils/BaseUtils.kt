package com.example.android.common.baseutils

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.telephony.PhoneNumberUtils
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.android.common.baseconstants.HAS_LOGGED_IN
import com.example.android.common.baseconstants.StaticConstants
import com.example.android.common.basedb.basedao.CategoryDao
import com.example.android.common.basedb.basedao.ProductDao
import com.example.android.ecommerce.model.Product
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.internal.LinkedTreeMap
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(TimeZone.getDefault().id)
}

class BaseUtils {

    companion object {

        @JvmStatic
        fun hasCategory(categoryDao: CategoryDao): Boolean {
            return categoryDao.getCheckHasCategory() != null
        }

        @JvmStatic
        fun getProductsOrderBy(productDao: ProductDao, column: String): List<Product?>? {
            val statement = "SELECT * FROM Product ORDER BY $column ASC"
            val query: SupportSQLiteQuery = SimpleSQLiteQuery(statement, arrayOf())
            return productDao.getProductsOrderBy(query)
        }

        @JvmStatic
        fun <T> toObject(jsonString: String, emptyObject: T, classOfObject: Class<T>): T {
            val newObject: T
            val gson = Gson()
            val type: Type =
                TypeToken.getParameterized(classOfObject, classOfObject).type
            gson.toJson(emptyObject, type)
            newObject = gson.fromJson(jsonString, type)
            return newObject
        }

        @JvmStatic
        fun <T> toJsonString(gsonSerializedObject: T): String {
            val gson = Gson()
            return gson.toJson(gsonSerializedObject)
        }

        @JvmStatic
        fun toJsonObject(linkedTreeMap: LinkedTreeMap<Any?, Any?>): JsonObject {
            val gson = Gson()
            return gson.toJsonTree(linkedTreeMap).asJsonObject
        }

        @JvmStatic
        fun toJsonString(jsonObject: JsonObject): String {
            val gson = Gson()
            return gson.toJson(jsonObject)
        }

        @JvmStatic
        fun <T> getNullOrJsonString(collection: List<T?>?): String? {
            if (collection.isNullOrEmpty()) {
                return null
            }
            return Gson().toJson(collection)
        }

        @JvmStatic
        fun <T> getNullOrList(data: String?, classOfObject: Class<T>): List<T?>? {
            if (StringUtils.isNullOrEmpty(data)) {
                return null //Because we want to check in query! Collections.emptyList()
            }
            return Gson().fromJson(data, getListTypeToken(classOfObject))
        }

        @JvmStatic
        fun <T> getListTypeToken(classOfObject: Class<T>): Type {
            return TypeToken.getParameterized(ArrayList::class.java, classOfObject).type
        }

        @JvmStatic
        fun hasLoggedIn(sharedPrefs: SharedPreferences): Boolean {
            return sharedPrefs.getString(HAS_LOGGED_IN, "").toString().isNotEmpty()
        }

        @JvmStatic
        fun isLoggedIn(sharedPrefs: SharedPreferences): Boolean {
            return sharedPrefs.getBoolean(HAS_LOGGED_IN, false)
        }

        @JvmStatic
        fun setBaseApiUrl(baseUrl: String) {
            StaticConstants.baseApiUrl = baseUrl
        }

        @JvmStatic
        fun getLocale(): Locale {
            return Locale.getAvailableLocales()[0]
        }

        @JvmStatic
        fun getCountryCode(): String {
            return PhoneNumberUtils.FORMAT_UNKNOWN.toString()
        }

        @JvmStatic
        fun openInBrowser(context: Context, pageUrl: String?) {
            pageUrl?.let {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
            }
        }

        /**
         * A [LifecycleOwner] is considered active if it is either STARTED or RESUMED.
         *
         * @param lifecycleOwner to check the state of.
         * @return whether the lifecycleOwner is active.
         */
        fun isInActiveState(@Nullable lifecycleOwner: LifecycleOwner?): Boolean {
            return (lifecycleOwner != null
                    && lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)
                    && lifecycleOwner.lifecycle.currentState != Lifecycle.State.DESTROYED
                    )
        }

        fun isSafeFragment(frag: Fragment): Boolean {
            return !(frag.isRemoving || frag.activity == null || frag.isDetached || !frag.isAdded || frag.view == null)
        }
    }
}