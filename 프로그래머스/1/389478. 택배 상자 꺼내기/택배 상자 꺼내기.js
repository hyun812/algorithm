// n: 창고에 있는 상자의 개수
// w: 가로로 놓는 상자의 개수
// num: 꺼내려는 택배 상자의 번호

function solution(n, w, num) {
    let answer = 0;
    
    const maxH = n % w === 0 ? Math.floor(n / w) : Math.floor(n / w) + 1;
    const graph = Array.from({ length: maxH }, () => Array(w).fill(0));
    
    let count = 1;
    let index = 0;
    let isRight = true;
    
    let targetW = 0;
    
    for (let i = maxH - 1; i >= 0; i--) {
        
        while (true) {
            if (count === n + 1) break;
            if (count === num) targetW = index;
            graph[i][index] = count;
            
            count++;
            index = isRight ? index + 1 : index - 1;
            if (index === w) {
                index--;
                break;
            }
            if (index === -1) {
                index++;
                break;
            }
        }
        isRight = !isRight;
    }
    
    for (let i = 0 ; i < maxH; i++) {
        if (!graph[i][targetW]) continue;
        if (graph[i][targetW] === num) break;
        
        answer++;
    }
    
    return answer + 1;
}