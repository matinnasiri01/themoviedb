package me.nasiri.domain.until

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


fun runOtherThread(block: suspend CoroutineScope.() -> Unit){
    CoroutineScope(Dispatchers.IO).launch(block = block)
}