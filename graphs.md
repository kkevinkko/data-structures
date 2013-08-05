Graphs [G = (V, E)]
===
Applications:
* Git
* Google Maps
* Facebook Graph API

Main Takeaways:
* Graph representation - Adjacency Lists & Adjacency Matrices
* Searching a graph
    * Following the edges.
        * Breadth-first
        * Depth-first
        * Best-first

(*definition.*) G = (V, E)
    Graph G is a tuple representing its set of vertices, V, and its
    set of edges, E.

(*definition*) Sparse and Dense graphs
    A graph G = (V, E) is sparse if
        |E| << |V|^2
    that is, if the set of actual edges is a lot smaller than the set of
    possible edges.
    and is dense if
        |E| ~= |V|^2
    that is, the set of actual edges are almost all of the possible edges.

Adjacency lists rep. are better for **sparse** graphs. Converse is true
for **dense** graphs.

If we need to check quickly if 2 vertices are connected quickly, we also
use adjacency matrices. O(1)
