package ccspkt.chapter4

class Graph<V>(val vertices: MutableList<V> = mutableListOf()) {
    val edges: MutableList<MutableList<Edge>> = vertices.map {
        mutableListOf<Edge>()
    }.toMutableList()

    fun vertexCount(): Int {
       return vertices.size
    }

    fun edgeCount(): Int {
        return edges.map { edge ->
            edge.size
        }.sum()
    }

    fun addVertex(vertex: V): Int {
        vertices.add(vertex)
        edges.add(mutableListOf())
        return vertexCount() - 1
    }

    fun addEdge(edge: Edge) {
        edges[edge.u].add(edge)
        edges[edge.v].add(edge.reversed())
    }

    fun addEdgeByIndices(u: Int, v: Int) {
        addEdge(Edge(u, v))
    }

    fun addEdgeByVertices(first: V, second: V) {
        val u = vertices.indexOf(first)
        val v = vertices.indexOf(second)
        addEdgeByIndices(u, v)
    }

    fun vertexAt(index: Int): V  {
        return vertices[index]
    }

    fun indexOf(vertex: V): Int {
        return vertices.indexOf(vertex)
    }

    fun neighborsForIndex(index: Int): List<V> {
        return edges[index].map { e -> vertexAt(e.v) }
    }

    fun neighborsForVertex(vertex: V): List<V> {
        return neighborsForIndex(indexOf(vertex))
    }

    fun edgesForIndex(index: Int): List<Edge> {
        return edges[index]
    }

    fun edgesForVertex(vertex: V): List<Edge> {
        return edgesForIndex(indexOf(vertex))
    }

    override fun toString(): String {
        return (0 until vertexCount()).fold("") { acc, i ->
            acc + "${vertexAt(i)} -> ${neighborsForIndex(i)}\n"
        }
    }
}