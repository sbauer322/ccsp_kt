package ccspkt.chapter3

abstract class Constraint<V, D>(variables: List<V>) where
V: Any, D: Any {

    abstract fun satisfied(assignment: Map<V, D>): Boolean

}