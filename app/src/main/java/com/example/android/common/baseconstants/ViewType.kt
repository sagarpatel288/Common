package com.example.android.common.baseconstants

/**
 * 3/12/2020
 * Taken sealed class over enum class considering its usage in when clause (freedom from else)
 * <p>
 *
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
sealed class ViewType(viewType: Int) {
    data class ViewTypeItem(val viewType: Int) : ViewType(100)
    data class ViewTypeLoading(val viewType: Int) : ViewType(110)
    object ViewTypeShimmer : ViewType(120)
}