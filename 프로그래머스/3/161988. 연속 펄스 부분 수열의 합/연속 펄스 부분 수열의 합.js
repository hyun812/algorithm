function solution(sequence) {
    let answer = 0;
    
    let sum = 0;
    let max = 0;
    let min = 0;
    
    // 누적합 계산
    for(let i=0; i<sequence.length; i++){
        const target = i%2 ? sequence[i] : -sequence[i];
        sum += target;
        
        max = Math.max(max, sum);
        min = Math.min(min, sum)
    }
    
    return max  === min ? max : max - min;
}