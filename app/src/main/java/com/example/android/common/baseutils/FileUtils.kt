package com.example.android.common.baseutils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider.getUriForFile
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.whenStateAtLeast
import com.example.android.common.BuildConfig
import com.example.android.common.R
import com.example.android.common.baseconstants.LOG_APP_NAME
import com.example.android.common.baseconstants.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.*


class FileUtils {
    companion object {
        @JvmStatic
        fun getJsonFromAsset(context: Context, jsonFileNameWithExtension: String): String {
            var jsonString: String = ""
            // comment by srdpatel: 2/4/2020  https://www.myandroidsolutions.com/2019/07/25/android-parse-json-file-from-assets/#.XjlT6WgzbDc
            try {
                val inputStream = context.assets.open(jsonFileNameWithExtension)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.use { it.read(buffer) }
                jsonString = String(buffer)
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return jsonString
            }
            // print the data
            Log.i("json: ", jsonString)
            return jsonString
        }

        @JvmStatic
        fun getAppDirName(context: Context): String {
            Timber.d(" :$LOG_APP_NAME: FileUtils: :getAppDirName: ${context.getString(R.string.app_name)}")
            return context.getString(R.string.app_name)
        }

        @JvmStatic
        fun createAppSpecificExternalDir(context: Context, directoryName: String): File? {
            val fileFolder = context.getExternalFilesDir(directoryName)
            if (fileFolder != null && !fileFolder.exists()) {
                val createdDirectory = fileFolder.mkdirs()
                Timber.d(" :$LOG_APP_NAME: FileUtils: :createAppSpecificExternalDir: createdDirectory $createdDirectory")
            }
            return fileFolder
        }

        @JvmStatic
        fun createAppExternalCacheDirectory(context: Context, directoryName: String): File {
            val file = File(context.externalCacheDir, directoryName)
            if (!file.mkdirs() || !file.exists()) {
                file.mkdirs()
            }
            return file
        }

        @JvmStatic
        fun copyFileTo(context: Context, destinationFileFolder: File, uri: Uri, fileName: String) {
            val inputStream = context.contentResolver.openInputStream(uri)
            if (inputStream != null) {
                if (!destinationFileFolder.exists()) {
                    val fileFolderCreated = destinationFileFolder.mkdirs()
                    Timber.d(" :$LOG_APP_NAME: FileUtils: :copyFileTo: fileFolderCreated: $fileFolderCreated")
                }
                val file = File("$destinationFileFolder/$fileName")
                val fos = FileOutputStream(file)
                val bis = BufferedInputStream(inputStream)
                val bos = BufferedOutputStream(fos)
                val byteArray = ByteArray(1024)
                var bytes = bis.read(byteArray)
                while (bytes > 0) {
                    bos.write(byteArray, 0, bytes)
                    bos.flush()
                    bytes = bis.read(byteArray)
                }
                bos.close()
                fos.close()
            }
        }

        @JvmStatic
        fun copyFileToAppExternalCacheDirectory(context: Context, uri: Uri, fileName: String) {
            val tempDir = context.externalCacheDir //App specific external cache directory
            tempDir?.let {
                copyFileTo(context, it, uri, fileName)
            }
        }

        @JvmStatic
        fun saveFileToAppExternalCacheFromIntent(
            context: Context,
            data: Intent,
            fileName: String = ""
        ) {
            getUriFromIntentData(data)?.let {
                copyFileToAppExternalCacheDirectory(
                    context,
                    it, fileName
                )
            }
        }

        @JvmStatic
        fun getFileNameFromIntentData(context: Context, data: Intent): String? {
            return getUriFromIntentData(data)?.let { getFileNameByUri(context, it) }
        }

        @JvmStatic
        fun getUriFromIntentData(data: Intent): Uri? {
            return data.data
        }

        @JvmStatic
        fun getFileNameByUri(context: Context, uri: Uri): String {
            var fileName = System.currentTimeMillis().toString()
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()
                fileName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME))
                cursor.close()
            }
            return fileName
        }

        @JvmStatic
        fun saveCreateTempCacheFile(context: Context, file: File, fileName: String = "") {
            File.createTempFile(
                if (fileName.isNotEmpty()) fileName else file.name,
                null,
                context.cacheDir // comment by srdpatel: 4/12/2021 Internal cache directory
            )
        }

        @JvmStatic
        fun getCacheTempFile(context: Context, fileName: String): File {
            return File(context.cacheDir, fileName) // comment by srdpatel: 4/12/2021 Internal cache directory
        }

        @JvmStatic
        fun saveFileToAppExternalCache(
            activity: AppCompatActivity? = null,
            fragment: Fragment? = null,
            file: File,
            fileName: String = ""
        ) {
            CoroutineScope(Dispatchers.IO).launch {
                (activity ?: fragment)?.lifecycle?.whenStateAtLeast(Lifecycle.State.RESUMED) {
                    copyToAppExternalCacheDir(activity, file)
                }
            }
        }

        @JvmStatic
        fun copyToAppExternalCacheDir(context: Context?, file: File, fileName: String = "") {
            context?.let {
                getUriFromFile(context, file)?.let { uri ->
                    copyFileToAppExternalCacheDirectory(
                        it, uri,
                        if (fileName.isNotEmpty()) fileName else file.name
                    )
                }
            }
        }

        @JvmStatic
        fun getUriFromFile(context: Context?, file: File): Uri? {
            /*Make sure that we are asking temporary grant uri permission through intent flag*/
            return context?.let { getUriForFile(it, BuildConfig.LIBRARY_PACKAGE_NAME, file) }
        }

        @JvmStatic
        fun getImageDirectory(context: Context): File {
            val imagePath = File(context.filesDir, "images")
            val newFile = File(imagePath, "default_image.jpg")
            val contentUri = getUriForFile(
                context,
                "com.example.android.common.fileprovider",
                newFile
            )
            return imagePath
        }

        @JvmStatic
        fun getAppExternalCacheFile(context: Context, fileName: String): File? {
            val dir = context.externalCacheDir
            dir?.let {
                if (dir.exists() && !dir.listFiles().isNullOrEmpty()) {
                    val listOfFiles = dir.listFiles()
                    listOfFiles?.let {
                        for (file in listOfFiles) {
                            Log.d(
                                " :$TAG: ",
                                "getAppExternalCacheFile: ${file.name}"
                            )
                            if (file.name.equals(fileName, false) ) {
                                return file
                            }
                        }
                    }
                }
            }
            return null
        }
    }
}