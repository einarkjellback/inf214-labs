import kotlin.concurrent.thread

fun main() {
    fun periodically(period: Long, f: () -> Unit) {
        thread {
            while (true) {
                f()
                Thread.sleep(period)
            }
        }
    }

    periodically(1000) { println("foobar") }
}