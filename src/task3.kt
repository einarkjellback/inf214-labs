import kotlin.concurrent.thread

fun main() {
    fun sumMatrices(A: List<List<Double>>, B: List<List<Double>>): List<List<Double>> {
        val resultMatrix = A.indices.map { listOf<Double>() }.toMutableList()
        val threads = resultMatrix.mapIndexed { i, _ ->
            thread {
                resultMatrix[i] = A[i].zip(B[i]).map { (a, b) -> a + b }
           }
        }
        threads.map { it.join() }
        return resultMatrix
    }

    val A = listOf(listOf(1.0, 2.0, 3.0), listOf(3.0, 1.0, 2.0))
    println(sumMatrices(A, A))
}