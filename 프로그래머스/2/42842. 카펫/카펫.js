function solution(brown, yellow) {
    
    for (let i = 1; i <= yellow; i++) {
        if (yellow % i !== 0) continue;
        
        let j = yellow / i;
        
        if ((i + 2) * (j + 2) === brown + yellow) {
            return [j + 2, i + 2]
        }
    }
}