package com.example.android.common.baseutils

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Base64
import java.io.ByteArrayOutputStream


fun main() {

}

class ImageUtils {

    companion object {

        @JvmStatic
        fun getBitmap(drawable: Drawable): Bitmap? {
            var bitmap: Bitmap? = null
            if (drawable is BitmapDrawable) {
                if (drawable.bitmap != null) {
                    return drawable.bitmap
                }
            }
            bitmap = if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
                Bitmap.createBitmap(
                    1,
                    1,
                    Bitmap.Config.ARGB_8888
                ) // Single color bitmap will be created of 1x1 pixel
            } else {
                Bitmap.createBitmap(
                    drawable.intrinsicWidth,
                    drawable.intrinsicHeight,
                    Bitmap.Config.ARGB_8888
                )
            }
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
            return bitmap
        }

        @JvmStatic
        fun getBase64String(bitmap: Bitmap): String {
            val byteArrayOutStream = ByteArrayOutputStream()
            bitmap.setHasAlpha(true)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutStream)
            val byteArray = byteArrayOutStream.toByteArray()
            return Base64.encodeToString(byteArray, Base64.DEFAULT)
        }

        @JvmStatic
        fun getBitmapFromBase64String(base64String: String):Bitmap {
            val decodedString: ByteArray = Base64.decode(base64String, Base64.DEFAULT)
            return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        }

        @JvmStatic
        fun getMutableBitmap(bitmap: Bitmap): Bitmap {
            return bitmap.copy(Bitmap.Config.ARGB_8888, true)
        }

        /**
         * @param bitmap The source bitmap.
         * @param opacity a value between 0 (completely transparent) and 255 (completely
         * opaque).
         * @return The opacity-adjusted bitmap.  If the source bitmap is mutable it will be
         * adjusted and returned, otherwise a new bitmap is created.
         */
        @JvmStatic
        fun setOpacity(bitmap: Bitmap, opacity: Int): Bitmap {
            val mutableBitmap =
                if (bitmap.isMutable) bitmap else bitmap.copy(Bitmap.Config.ARGB_8888, true)
            val canvas = Canvas(mutableBitmap)
            val paint = Paint()
            paint.alpha = 100 //srdpatel: alpha 0 means total transparency. 100 means full opacity (no transparency)
            val colour = opacity and 0xFF shl 24
            canvas.drawColor(colour, PorterDuff.Mode.DST_IN)
            canvas.drawColor(Color.WHITE)
            canvas.drawBitmap(bitmap, 0f, 0f, paint)
            return mutableBitmap
        }

        /**
         * @param bitmap The source bitmap.
         * @param alpha a value between 0 (completely transparent) and 255 (completely
         * opaque).
         * @return The opacity-adjusted bitmap.  If the source bitmap is mutable it will be
         * adjusted and returned, otherwise a new bitmap is created.
         */
        @JvmStatic
        fun setAlpha(bitmap: Bitmap, alpha: Int): Bitmap {
           return setOpacity(bitmap, alpha)
        }

        /**
         * @param bitmap The source bitmap.
         * @param opacityAlpha a value between 0 (completely transparent) and 255 (completely
         * opaque).
         * @return The opacity-adjusted bitmap.  If the source bitmap is mutable it will be
         * adjusted and returned, otherwise a new bitmap is created.
         */
        @JvmStatic
        fun setTransparency(bitmap: Bitmap, opacityAlpha: Int): Bitmap {
            return setOpacity(bitmap, opacityAlpha)
        }
    }
}