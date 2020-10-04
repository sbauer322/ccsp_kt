package ccspkt.chapter4

class Edge(val u: Int, val v: Int) {

    fun reversed(): Edge {
        return Edge(v, u)
    }

    override fun toString(): String {
        return "$u -> $v"
    }
}