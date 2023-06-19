function solution(n, words) {
  let set = new Set([words[0]]);
  let lastWord = words[0].at(-1);

  for (let i = 1; i < words.length; i++) {
    if (words[i].length === 1 || words[i][0] != lastWord || set.has(words[i])) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    }

    set.add(words[i]);
    lastWord = words[i].at(-1);
  }

  return [0, 0];
}
