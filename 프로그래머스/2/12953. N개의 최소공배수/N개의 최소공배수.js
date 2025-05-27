const gcd = (a, b) => {
    if (b === 0) return a;
    return gcd(b, a % b);
}

function solution(arr) {
    let target = 1;
    
    for (const num of arr) {
        target = (num * target) / gcd(num, target);
    }
    
    return target;
}