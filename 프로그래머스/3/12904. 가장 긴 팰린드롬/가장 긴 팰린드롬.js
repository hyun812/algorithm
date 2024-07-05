function solution(s) {
    let answer = 1;

    const len = s.length;
    const dp = Array.from({length: len}, () => Array(len).fill(0));
    
    
    for(let i=0; i<len; i++){
        dp[i][i] = 1; // 자기 자신은 항상 팰린드롬
        if(s[i] === s[i+1]){
            dp[i][i+1] = 1;
            answer = 2;
        }
    }
    
    for(let i=3; i<=len; i++){ // 팰린드롬의 길이
        for(let start=0; start<=len-i; start++){ // 시작 인덱스
            const end = start + i - 1; // 마지막 인덱스
            
            if(s[start] === s[end] && dp[start+1][end-1]){
                dp[start][end] = 1;
                answer = i;
            }
        }
    }
    
    return answer;
}