import ccspkt.chapter3.CSP
import ccspkt.chapter3.QueensConstraint
import ccspkt.chapter4.Graph

fun main() {
//    chapter3Main()
    chapter4Main()
}

fun chapter3Main() {
    val columns: MutableList<Int> = mutableListOf(1,2,3,4,5,6,7,8)
    val rows: MutableMap<Int, List<Int>> = mutableMapOf()

    columns.forEach { column ->
        rows[column] = listOf(1,2,3,4,5,6,7,8)
    }

    val csp = CSP(columns, rows)
    csp.addConstraint(QueensConstraint(columns))
    val solution = csp.backtrackingSearch()

//    val csp = CSPE(columns, rows)
//    csp.addConstraint(QueensConstraintE(columns))
//    val solution = csp.backtrackingSearch()

    if (solution != null) {
        print(solution)
    } else {
        print("No solution found")
    }
}

fun chapter4Main() {
    val cityGraph = Graph<String>(
        mutableListOf("Seattle", "San Francisco", "Los Angeles",
        "Riverside", "Phoenix", "Chicago", "Boston", "New York",
        "Atlanta", "Miami", "Dallas", "Houston", "Detroit", "Philadelphia",
        "Washington"))
    cityGraph.addEdgeByVertices("Seattle", "Chicago")
    cityGraph.addEdgeByVertices("Seattle", "San Francisco")
    cityGraph.addEdgeByVertices("San Francisco", "Riverside")
    cityGraph.addEdgeByVertices("San Francisco", "Los Angeles")
    cityGraph.addEdgeByVertices("Los Angeles", "Riverside")
    cityGraph.addEdgeByVertices("Los Angeles", "Phoenix")
    cityGraph.addEdgeByVertices("Riverside", "Phoenix")
    cityGraph.addEdgeByVertices("Riverside", "Chicago")
    cityGraph.addEdgeByVertices("Phoenix", "Dallas")
    cityGraph.addEdgeByVertices("Phoenix", "Houston")
    cityGraph.addEdgeByVertices("Dallas", "Chicago")
    cityGraph.addEdgeByVertices("Dallas", "Atlanta")
    cityGraph.addEdgeByVertices("Dallas", "Houston")
    cityGraph.addEdgeByVertices("Houston", "Atlanta")
    cityGraph.addEdgeByVertices("Houston", "Miami")
    cityGraph.addEdgeByVertices("Atlanta", "Chicago")
    cityGraph.addEdgeByVertices("Atlanta", "Washington")
    cityGraph.addEdgeByVertices("Atlanta", "Miami")
    cityGraph.addEdgeByVertices("Miami", "Washington")
    cityGraph.addEdgeByVertices("Chicago", "Detroit")
    cityGraph.addEdgeByVertices("Detroit", "Boston")
    cityGraph.addEdgeByVertices("Detroit", "Washington")
    cityGraph.addEdgeByVertices("Detroit", "New York")
    cityGraph.addEdgeByVertices("Boston", "New York")
    cityGraph.addEdgeByVertices("New York", "Philadelphia")
    cityGraph.addEdgeByVertices("Philadelphia", "Washington")
    print(cityGraph)
}