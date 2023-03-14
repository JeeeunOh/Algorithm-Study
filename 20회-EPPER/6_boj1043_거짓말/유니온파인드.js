const init = (N) => {
    return Array(N)
      .fill(0)
      .map((value, idx) => idx);
  };
  
  const find = (x, parent) => {
    if (parent[x] === x) {
      return x;
    }
    const currentParent = find(parent[x], parent);
    parent[x] = currentParent;
  
    return currentParent;
  };
  
  const union = (A, B, parent) => {
    const rootA = find(A, parent);
    const rootB = find(B, parent);
  
    rootA < rootB ? (parent[rootB] = rootA) : (parent[rootA] = rootB);
  };