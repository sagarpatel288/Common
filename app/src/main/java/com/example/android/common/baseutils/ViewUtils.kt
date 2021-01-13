package com.example.android.common.baseutils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog

class ViewUtils {
    companion object {

        /**
         * 6/12/2020
         * @param view must be a parent view and must implement:
         * ```xml
         * app:layout_behavior="android.support.design.widget.BottomSheetBehavior"
         * ```
         * @author srdpatel
         * @since 1.0
         */
        @JvmStatic
        fun showBottomSheetDialog(context: Context, view: View): BottomSheetDialog {
            val bottomSheetDialog = BottomSheetDialog(context)
            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()
            return bottomSheetDialog
        }

        @JvmStatic
        fun getView(context: Context, resLayId: Int): View {
            return LayoutInflater.from(context).inflate(resLayId, null)
        }


    }
}