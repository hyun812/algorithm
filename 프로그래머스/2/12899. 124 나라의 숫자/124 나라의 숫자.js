function solution(n) {
    let answer = '';
    
    // 3으로 나눈 나머지를 이용 순서 4,1,2
    const mod = ["4","1","2"];
    
    while(n > 0){    
        answer = mod[n%3] + answer;
        //3과 정확히 떨어지면 몫이 1이 생기기 때문에 -1을 해준후 계산한다.
        n = parseInt((n-1)/3);
    }
    
    return answer;
}