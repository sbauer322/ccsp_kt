package ccspk.chapter3

import kotlin.math.abs

class QueensConstraintE(val columns: List<Int>): Constraint<Int, Int>(columns) {
    override fun satisfied(assignment: Map<Int, Int>): Boolean {
        return assignment.entries.all { entry: Map.Entry<Int, Int> ->
            val q1c = entry.key
            val q1r = entry.value

            (q1c+1 .. columns.size+1).all {q2c ->
                isQueenSafe(assignment, q1r, q1c, q2c)
            }
        }
    }

    fun isQueenSafe(assignment: Map<Int, Int>, q1r: Int, q1c: Int, q2c: Int) : Boolean {
        return if (q2c in assignment) {
            val q2r = assignment[q2c]!!
            !isThreatened(q1r, q1c, q2r, q2c)
        } else {
            true
        }
    }

    fun isThreatened(q1r: Int, q1c: Int, q2r: Int, q2c: Int): Boolean {
        val isSameRow = q1r == q2r
        val isSameDiagonal = abs(q1r - q2r) == abs(q1c - q2c)

        return isSameRow || isSameDiagonal
    }


}