function solution(id_list, report, k) {
  const newRepo = [...new Set(report)];
  const out = []; // 정지 아이디
  const count = Array(id_list.length).fill(0); // 신고수
  const mail = Array(id_list.length).fill(0); // 메일수

  for (let r of newRepo) {
    let a = r.split(' ')[0];
    let b = r.split(' ')[1];
    let idxB = id_list.indexOf(b);
    count[idxB] += 1;

    if (count[idxB] >= k) {
      out.push(id_list[idxB]);
    }
  }

  newRepo.map((r, idx) => {
    let a = r.split(' ')[0]; // 유저 ID
    let b = r.split(' ')[1]; // 유저가 신고한 ID

    if (out.indexOf(b) != -1) {
      let idx = id_list.indexOf(a);
      mail[idx] += 1;
    }
  });

  return mail;
}
