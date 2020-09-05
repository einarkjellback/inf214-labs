import kotlin.concurrent.thread

fun main() {
    fun periodically(f: () -> Unit, period: Long) {
        thread {
            while (true) {
                f()
                Thread.sleep(period)
            }
        }
    }

    periodically({ println("foobar") }, 1000)
}