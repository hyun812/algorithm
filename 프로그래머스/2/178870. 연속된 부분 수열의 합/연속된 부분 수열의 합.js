function solution(sequence, k) {
    const answer = [0, Infinity];
    
    let left = 0;
    let right = 0;
    
    let sum = sequence[0];
    
    while (left <= right && right < sequence.length) {
        if (sum === k) {
            if (answer[1] - answer[0] > right - left) {
                answer[0] = left;
                answer[1] = right;
            }else if (answer[1] - answer[0] === right - left && left < answer[0]) {
                answer[0] = left;
                answer[1] = right;
            }
            right++;
            sum += sequence[right];
            sum -= sequence[left];
            left++;
        }else if (sum < k) {
            right++;
            sum += sequence[right];
        }else {
            sum -= sequence[left];
            left++;
        }
    }
    
    return answer;
}