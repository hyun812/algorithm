function solution(n,a,b) {
    let cnt = 1;
    
    while (true) {
        if (Math.floor((a + 1) / 2) === Math.floor((b + 1) / 2)) break;
        
        a = (a + 1) / 2;
        b = (b + 1) / 2;
        cnt++;
    }
    return cnt;
}