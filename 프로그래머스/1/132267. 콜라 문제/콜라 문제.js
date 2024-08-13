function solution(a, b, n) {
    let answer = 0;

    while(n >= a){
        let temp = Math.floor(n/a) * b; 
        
        answer += temp;
        n = temp + n % a;
    }
    return answer;
}