const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

let [N, Q] = input[0].split(' ').map(Number);
let graph = Array.from(Array(N + 1), () => []);

for (let i = 1; i < N; i++) {
  let [p, q, number] = input[i].split(' ').map(Number);
  graph[p].push({ link: q, number });
  graph[q].push({ link: p, number });
}

for (let i = N; i < N + Q; i++) {
  let [k, v] = input[i].split(' ').map(Number);
  let ans = 0;
  let queue = [v];

  const visited = new Array(N + 1).fill(false);
  visited[v] = true;

  while (queue.length) {
    const now = queue.shift();
    for (let next of graph[now]) {
      const { link, number } = next;
      if (visited[link] || number < k) continue;
      visited[link] = true;
      ans++;
      queue.push(link);
    }
  }

  console.log(ans);
}
