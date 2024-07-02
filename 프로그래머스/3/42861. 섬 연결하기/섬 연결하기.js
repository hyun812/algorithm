const union = (parents, a, b) => {
    let aRoot = find(parents, a);
    let bRoot = find(parents, b);
    
    if(aRoot === bRoot) return false;
    
    parents[bRoot] = aRoot;
    return true;
}

const find = (parents, a) => {
    if(a == parents[a]) return a;
    else {
        let b = find(parents, parents[a]);
        parents[a] = b;
        return b;
    }
}

function solution(n, costs) {
    let answer = 0;
    
    const parents = [];
    for(let i = 0; i < n; i++)
        parents.push(i);
    
    costs.sort((a,b) => a[2] - b[2]); // 비용이 낮은순으로 정렬
    
    for(const cost of costs){
        if(union(parents, cost[0], cost[1])){
            answer += cost[2];
        }
    }
    
    return answer;
}