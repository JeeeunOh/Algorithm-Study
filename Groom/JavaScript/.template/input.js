const readFileSyncAddress =
  process.platform === 'linux'
    ? '/dev/stdin'
    : '/Users/jieun/Documents/GitHub/Algorithm_Study/Groom/JavaScript/input.txt';

const input = require('fs')
  .readFileSync(readFileSyncAddress)
  .toString()
  .trimEnd()
  .split('\n');

console.log(input);
