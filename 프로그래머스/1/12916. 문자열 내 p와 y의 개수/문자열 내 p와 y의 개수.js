function solution(s){
    let pCount = 0;
    let yCount = 0;
    
    s = s.toLowerCase();
    for (const char of s) {
        if (char === 'p') pCount++;
        else if (char === 'y') yCount++;
    }


    return pCount === yCount;
}