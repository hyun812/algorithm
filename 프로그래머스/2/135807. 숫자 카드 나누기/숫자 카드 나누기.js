const gcd =  (a, b) => a % b === 0 ? b : gcd(b, a % b);

function solution(arrayA, arrayB) {
    
    let answer = 0;
    let gcdA = 0;
    let gcdB = 0;
    
    arrayA.forEach(val => gcdA = gcd(gcdA, val));
    arrayB.forEach(val => gcdB = gcd(gcdB, val));
    
    if(arrayA.every((v) => v % gcdB !== 0)) answer = Math.max(answer, gcdB);
    if(arrayB.every((v) => v % gcdA !== 0)) answer = Math.max(answer, gcdA);
    
    return answer;
}

