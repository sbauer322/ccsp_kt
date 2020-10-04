package ccspkt.chapter3

import kotlin.math.abs

class QueensConstraint(val columns: List<Int>): Constraint<Int, Int>(columns) {
    override fun satisfied(assignment: Map<Int, Int>): Boolean {
        assignment.entries.forEach { entry: Map.Entry<Int, Int> ->
            val q1c = entry.key
            val q1r = entry.value

            (q1c+1 .. columns.size+1).forEach {q2c ->
                if (q2c in assignment) {
                    val q2r = assignment[q2c]!!
                    if (q1r == q2r || abs(q1r - q2r) == abs(q1c - q2c)) {
                        return false
                    }
                }
            }
        }

        return true
    }

}