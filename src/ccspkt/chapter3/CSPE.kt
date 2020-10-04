package ccspkt.chapter3

import java.util.*

class CSPE<V, D>(val variables: List<V>, val domains: Map<V, List<D>>) where V: Any, D: Any {
    val constraints: MutableMap<V, MutableList<Constraint<V, D>>> = mutableMapOf()

    init {
        variables.forEach { variable ->
            constraints[variable] = mutableListOf()
            if (variable !in domains) {
                throw Error("Every variable should have a domain assigned to it.")
            }
        }
    }

    fun addConstraint(constraint: Constraint<V, D>) {
        variables.forEach {variable ->
            if (variable !in variables) {
                throw Error("Every variable should have a domain assigned to it.")
            } else {
                constraints[variable]!!.add(constraint)
            }
        }
    }

    fun consistent(variable: V, assignment: Map<V, D>): Boolean {
        return constraints[variable]!!.all { constraint -> constraint.satisfied(assignment) }
    }

    fun backtrackingSearch(assignment: Map<V, D> = mapOf()) : Map<V, D>? {
        return if (assignment.size == variables.size) {
            return assignment
        } else {
            val unassigned: List<V> = variables.filter { variable -> variable !in assignment }
            val first = unassigned[0]

            domains[first]!!.fold(assignment) { acc, value ->
                val localAssignment = acc.toMutableMap()
                localAssignment[first] = value

                if (consistent(first, localAssignment)) {
                    val result = backtrackingSearch(localAssignment)

                    if (result != null) {
                        result
                    } else {
                        acc
                    }
                } else {
                    acc
                }
            }

//            domains[first]!!.forEach{ value ->
//                val localAssignment = assignment.toMutableMap()
//                localAssignment[first] = value
//                if (consistent(first, localAssignment)) {
//                    val result = backtrackingSearch(localAssignment)
//
//                    if (result.isPresent) {
//                        return result
//                    }
//                }
//            }
//
//            return Optional.empty()
        }
    }
}