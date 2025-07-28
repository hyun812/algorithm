function solution(sequence, k) {
    let answer = [0, 0];
    let len = Infinity
    
    let l = 0;
    let r = 0;
    let sum = sequence[0];
    while (l <= r && r < sequence.length) {
        if (sum < k) {
            r++;
            sum += sequence[r];
        } else if (sum > k) {
            sum -= sequence[l];
            l++;
        } else {
            if (len > r - l + 1) {
                answer[0] = l;
                answer[1] = r;
                len = r - l + 1;
            }
            r++;
            sum += sequence[r];
        }
    }
    
    return answer;
}