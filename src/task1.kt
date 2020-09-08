import kotlin.concurrent.thread

fun main() {
    fun <T, R> parallel(f: () -> T, g: () -> R): Pair<T, R> {
        var resultF: T? = null
        var resultG: R? = null
        val threads = listOf(
            thread { resultF = f() },
            thread { resultG = g() }
        )
        threads.map { it.join() }
        return Pair(resultF!!, resultG!!)
    }
}