package com.example.android.common.baseconstants


/**
 * 2/29/2020
 * If you want to change [BASE_URL_GITHUB], make it kind of static using companion object
 * @see <a href="http://google.com"></a>
 * [ReadableHyperlinkText]( "")
 * @author srdpatel
 * @since 1.0
 */
const val BASE_URL_GITHUB: String = "https://api.github.com/";
const val BASE_URL_REDDIT: String = "https://www.reddit.com/";
const val BASE_URL_OPEN_WEATHER_MAP: String = "https://api.openweathermap.org/data/2.5/";
const val PARCEL: String = "parcel"
const val ID: String = "id"
const val PARENT_ID: String = "parent_id"
const val TITLE: String = "title"
const val NAME: String = "name"
const val FULL_NAME: String = "full_name"
const val FIRST_NAME: String = "first_name"
const val MIDDLE_NAME: String = "middle_name"
const val LAST_NAME: String = "last_name"
const val SUB_TITLE: String = "sub_title"
const val PRICE: String = "price"
const val UNIT: String = "unit"
const val REMAINING: String = "remaining"
const val STATUS: String = "status"
const val ONE: String = "1"
const val ZERO: String = "0"
const val MIN_ORDER: String = "min_order"
const val PHOTO: String = "photo"
const val CATEGORY: String = "category"
const val ROLE: String = "role"
const val EMAIL: String = "email"
const val MOBILE_NUMBER: String = "mobile_number"
const val USER_ID: String = "user_id"
const val LOGIN_ID: String = "login_id"
const val LOGIN_TOKEN: String = "login_token"

class StaticConstants {
    companion object {
        var baseApiUrl = BASE_URL_GITHUB
    }
}