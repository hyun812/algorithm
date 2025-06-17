function solution(n, left, right) {
    const size = right - left + 1;
    const arr = new Array(size).fill(0);
    
    for (let i = 0; i < size; i++) {
        let index = left + i;
        let row = Math.floor(index / n);
        let col = Math.floor(index % n);
        
         arr[i] = Math.max(row, col) + 1;
    }
    
    return arr
}