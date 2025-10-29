function solution(n, stations, w) {
    let answer = 0;
    let pos = 1;
    let index = 0;
    
    while (pos <= n) {
        if (pos >= stations[index] - w && pos <= stations[index] + w) {
            pos = stations[index++] + w;
        } else {
            pos += 2 * w;
            answer++;
        }
        pos++;
    }
    
    return answer;
}