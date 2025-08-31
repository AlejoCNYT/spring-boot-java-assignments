import sys
sys.setrecursionlimit(1 << 25)

class GraphCoverSolver:
    def __init__(self):
        self.graph = {}
        self.visited = []
        self.color = []
        self.part0 = []
        self.part1 = []

    def init_graph(self, n, edges):
        self.graph = {i: [] for i in range(1, n + 1)}
        for u, v in edges:
            self.graph[u].append(v)
            self.graph[v].append(u)
        self.visited = [False] * (n + 1)
        self.color = [0] * (n + 1)
        self.part0 = []
        self.part1 = []

    def bfs(self, start):
        queue = [start]
        self.visited[start] = True
        self.color[start] = 0
        self.part0.append(start)

        while queue:
            node = queue.pop(0)
            for neighbor in self.graph[node]:
                if not self.visited[neighbor]:
                    self.visited[neighbor] = True
                    self.color[neighbor] = 1 - self.color[node]
                    if self.color[neighbor] == 0:
                        self.part0.append(neighbor)
                    else:
                        self.part1.append(neighbor)
                    queue.append(neighbor)

    def solve(self, n, edges):
        self.init_graph(n, edges)
        self.bfs(1)  # Siempre está garantizado que el grafo es conexo
        chosen = self.part0 if len(self.part0) <= n // 2 else self.part1
        print(len(chosen))
        print(" ".join(str(x) for x in chosen))


# === MAIN PARA EL JUEZ ===
def main():
    t = int(input())
    for _ in range(t):
        n, m = map(int, input().split())
        edges = []
        for _ in range(m):
            u, v = map(int, input().split())
            edges.append((u, v))
        solver = GraphCoverSolver()
        solver.solve(n, edges)

# Ejecutar
main()
