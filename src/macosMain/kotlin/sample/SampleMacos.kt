package sample

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.broadcast
//import kotlin.coroutines.*

fun main() {
    runBlocking {
        ViewModel()
        while(true) {
            yield()
        }
    }
}

class View {
    init {
        ViewModel()
    }
}

class ViewModel : CoroutineScope {
    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job + CoroutineExceptionHandler { _, e -> println(e) }

    init {
        launch {
            println("this coroutine runs")
        }
    }
}

