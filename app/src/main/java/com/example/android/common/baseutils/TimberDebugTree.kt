package com.example.android.common.baseutils

import timber.log.Timber

// comment by srdpatel: 2/19/2021  https://stackoverflow.com/questions/38689399/log-method-name-and-line-number-in-timber
class TimberDebugTree: Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "(${element.fileName}:${element.lineNumber})#${element.methodName}"
    }
}