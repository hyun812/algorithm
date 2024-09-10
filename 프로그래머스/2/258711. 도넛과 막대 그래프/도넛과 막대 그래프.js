function solution(edges) {

    const graph = new Map();
    edges.forEach((edge) => {
        const [from, to] = edge;
        
        graph.set(from, graph.get(from) ? [graph.get(from)[0] + 1, graph.get(from)[1]] : [1, 0]);
        graph.set(to, graph.get(to) ? [graph.get(to)[0], graph.get(to)[1] + 1] : [0, 1]);
    })
    
    const answer = new Array(4).fill(0);
    
    for(const [key, value] of graph) {
        const [from, to] = value;

        if(from >= 2 && to === 0) { // 정점
            answer[0] = key;
        }else if(from === 0) { // 막대 그래프
            answer[2]++;
        }else if(from >= 2 && to >= 2) { //  8자 그래프
            answer[3]++;
        }
    }
    
    // 도넛 그래프
    answer[1] = graph.get(answer[0])[0] - answer[2] - answer[3];
    
    return answer;
}