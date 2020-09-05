import kotlin.concurrent.thread

fun main() {
    fun <T, R> parallel(f: () -> T, g: () -> R):  Pair<T, R> {
        var resultF: T? = null
        val tf = thread {
            resultF = f()
        }
        var resultG: R? = null
        thread {
            resultG = g()
        }.join()
        tf.join()
        return Pair(resultF!!, resultG!!)
    }

    val f = {'f'}
    val g = {'g'}
    println(parallel(f, g))
}