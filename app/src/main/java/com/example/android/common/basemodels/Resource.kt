package com.github.harmittaa.koinexample.networking

/**
 * 3/3/2020
 * This is an Upper Bounded Generic class
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
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
