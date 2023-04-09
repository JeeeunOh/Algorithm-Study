// 그래프 표현

const graph = {
  A: ['B', 'C'],
  B: ['A', 'D'],
  C: ['A', 'G', 'H', 'I'],
  D: ['B', 'E', 'F'],
  E: ['D'],
  F: ['D'],
  G: ['C'],
  H: ['C'],
  I: ['C', 'J'],
  J: ['I'],
};

// DFS : 재귀 : 한 개의 큐, 한 개의 스택
// 이전 노드와 연결된 노드들을 먼저 탐색해야하기 때문에 큐
const bfs = (graph, startNode) => {
  let visited = []; // 탐색 마친 노드
  let queue = []; // 탐색할 노드

  queue.push(startNode); // 노드 탐색 시작

  while (queue.length != 0) {
    const node = queue.shift();
    if (!visited.includes(node)) {
      visited.push(node);
      queue = [...queue, ...graph[node]];
    }
  }

  return visited;
};
console.log(bfs(graph, 'A'));
// ["A", "B", "C", "D", "G", "H", "I", "E", "F", "J"]

// BFS : 최단거리 : 두 개의 큐
// 자기 자신과 연결되었던 노드들 먼저 탐색하기 때문에 스택
const dfs = (graph, startNode) => {
  let stack = []; // 탐색해야할 노드
  let visited = []; // 탐색 마친 노드

  stack.push(startNode);

  while (stack.length != 0) {
    const node = stack.pop();
    if (!visited.includes(node)) {
      visited.push(node);
      stack = [...stack, ...graph[node]];
    }
  }

  return visited;
};

console.log(dfs(graph, 'A'));
// ["A", "C", "I", "J", "H", "G", "B", "D", "F", "E"]
