package me.nasiri.domain.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


fun <T> runOtherThread(block: suspend CoroutineScope.() -> T): T {
    var result: T? = null
    CoroutineScope(context = Dispatchers.IO).launch(block = { result = block(this) })
    return result!!
}