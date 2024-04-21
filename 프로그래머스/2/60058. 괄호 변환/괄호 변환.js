function solution(p) {
    // 빈문자열인 경우 반환
    if(!p) return "";
    
    let [u, v] = ["", ""];
    let [lcnt, rcnt] = [0, 0];
    
    // 더 이상 분리할 수 없는 균형잡힌 문자열 u 생성
    for(let i=0; i<p.length; i++){
        p[i] === '(' ? ++lcnt : ++rcnt;
        
        u += p[i];
        
        if(lcnt === rcnt){
            v = p.slice(i+1, p.length);
            break;
        }
    }
    
    // u가 올바른 괄호 문자열이라면
    if(u[u.length -1] === ')') return u+solution(v);
    else { // u가 올바른 문자열이 아니라면
        
        // 첫번째와 마지막 문자 제거
        u = u.slice(1, u.length -1).split("");
        
        // 나머지 문자열 괄호 방향 뒤집기
        for(let i=0; i<u.length; i++){
            u[i] = u[i] === ')' ? '(' : ')';
        }
        
        // ( + v에 대해 수행한 문자열 + ) + 뒤에 붙이기
        return "(" + solution(v) + ")" + u.join("");
    }
}