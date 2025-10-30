function solution(jobs) {
  jobs.sort((a, b) => a[0] - b[0]); // 요청 시점 기준 정렬
  const heap = [];
  let time = 0;
  let total = 0;
  let index = 0;

  while (index < jobs.length || heap.length > 0) {
    while (index < jobs.length && jobs[index][0] <= time) {
      heap.push(jobs[index++]);
      heap.sort((a, b) => a[1] - b[1]); // 소요 시간 기준 정렬
    }

    if (heap.length === 0) {
      time = jobs[index][0]; // 다음 요청 시간으로 점프
    } else {
      const [start, duration] = heap.shift();
      time += duration;
      total += time - start;
    }
  }

  return Math.floor(total / jobs.length);
}
