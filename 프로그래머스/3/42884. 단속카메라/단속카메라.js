function solution(routes) {
    let answer = 1;
    
    routes.sort((a, b) => a[0] - b[0]);
    
    let prev = routes[0][1];
    for (let i = 1; i < routes.length; i++) {
        if (prev < routes[i][0]) {
            answer++;
            prev = routes[i][1];    
        } 
        
        if (prev > routes[i][1]) { // 작은 것 기준으로
            prev = routes[i][1];
        } 
    }
    
    return answer;
}