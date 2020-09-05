import java.util.concurrent.Executor
import kotlin.concurrent.thread

fun main() {
    fun matrixSum(A: List<List<Double>>, B: List<List<Double>>): List<List<Double>> {
        val prepareToSum = A.indices.map {
            {
                val rowA = A[it]
                val rowB = B[it]
                var summedRow: List<Double> = listOf(0.0)
                thread {
                    summedRow = rowA.zip(rowB).map { (a, b) -> a + b }
                }
                summedRow
            }
        }
        val summedMatrices = prepareToSum.map { it() }
        val executor = Executor()
    }

    val A = listOf(listOf(1.0, 2.0, 3.0), listOf(3.0, 1.0, 2.0))
    val B = A
    println(matrixSum(A, B))
}