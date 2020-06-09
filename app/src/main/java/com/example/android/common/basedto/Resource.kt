package com.example.android.common.basedto

/**
 * 3/3/2020
 * This is an Upper Bounded Generic class
 * <p>
 * Why this class?
 * Because, we want to have a common thing while using retrofit suspend function to handle the response and return the data.
 * Using suspend function, we can omit call.enqueue call and the old onSuccess and onFail callbacks of retrofit.
 * To know more about suspend function, head over to:
 * @see <a href="https://proandroiddev.com/suspend-what-youre-doing-retrofit-has-now-coroutines-support-c65bd09ba067">Kotlin Suspend function</a>
 * [Kotlin Suspend function] (https://proandroiddev.com/suspend-what-youre-doing-retrofit-has-now-coroutines-support-c65bd09ba067 "Kotlin Suspend function")
 * <p>
 * We have used upper bound generic (covariance) instead of invariance generic for the flexibility
 * to allow children use this class as Resource<child>.
 * Talking about our specific case, we can use Resource<Weather> or Resource<ChildOfWeather>.
 * By getting this flexibility, we can use this class for any child and still get the parent.
 * </p>
 *  {@link #} []
 *
 * @param
 * @return
 * @author srdpatel
 * @see <a href="http://google.com"></a>
 * [] (http://google.com "")
 * @since 1.0
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {

        @JvmStatic
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        @JvmStatic
        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        @JvmStatic
        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
