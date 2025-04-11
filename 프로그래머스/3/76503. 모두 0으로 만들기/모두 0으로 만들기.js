function solution(a, edges) {
    if (a.reduce(((acc, cur) => acc + cur), 0) !== 0) return -1
    
    const graph = Array.from({ length: a.length }, () => []);
    for (const [from, to] of edges) {
        graph[from].push(to);
        graph[to].push(from);    
    }
    
    let answer = 0n;
    const visited = new Array(a.length).fill(0);
    const stack = [ [0, -1] ];     
    
    while (stack.length) {
        const [cur, parent] = stack.pop();
        
        if (visited[cur]) {
            a[parent] += a[cur];
            answer += BigInt(Math.abs(a[cur]));
            continue;    
        }
        
        stack.push([cur, parent]);
        visited[cur] = 1;
        
        for (const next of graph[cur]) {
            if (visited[next]) continue;
            stack.push([next, cur]);
        }
    }
    return a[0] ? -1 : answer;
}