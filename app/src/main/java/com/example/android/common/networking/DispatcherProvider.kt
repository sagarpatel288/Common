package com.example.android.common.networking

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

// comment by srdpatel: 4/7/2020 More on Dispatcher: https://medium.com/mindful-engineering/fast-lane-to-coroutines-bce8388ed82b
interface DispatcherProvider {

    // comment by srdpatel: 12/3/2019 single expression function, expression body
    fun main(): CoroutineDispatcher = Dispatchers.Main
    fun default(): CoroutineDispatcher = Dispatchers.Default
    fun io(): CoroutineDispatcher = Dispatchers.IO
    fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}

// comment by srdpatel: 4/8/2020 Will be used as delegated SR class to provide thread
class DefaultDispatcherProvider : DispatcherProvider