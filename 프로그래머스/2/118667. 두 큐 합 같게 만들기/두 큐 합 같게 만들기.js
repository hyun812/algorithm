function solution(queue1, queue2) {
    const newQueue = [...queue1, ...queue2];
    let sq1 = queue1.reduce((acc, cur) => acc + cur, 0);
    let sq2 = queue2.reduce((acc, cur) => acc + cur, 0);
    
    if (sq1 === sq2) return 0;
    if ((sq1 + sq2) % 2 !== 0) return -1;
    
    const goal = (sq1 + sq2) / 2;
    
    let left = 0;
    let right = queue1.length - 1;
    let cnt = 0;
    
    while (left <= right && right < newQueue.length) {
        if (goal === sq1) {
            return cnt;
        } else if (goal > sq1) {
            right++;
            sq1 += newQueue[right];
        } else {
            sq1 -= newQueue[left];
            left++;
        }
        cnt++;
    }
    return -1;
}