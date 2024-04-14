// n개의 마을
// k시간 이하로 배달 해야함

function solution(N, road, K) {
    const lines = Array.from({length: N+1} , () => []);    
    
    road.forEach((value)=>{
        let [a,b,c] = value;
        
        lines[a].push({ to: b, cost: c });
        lines[b].push({ to: a, cost: c });
    })
    
    const arr = Array(N+1).fill(Number.MAX_SAFE_INTEGER);
    const queue = [ {to: 1, cost: 0}] ;
    arr[1] = 0;
    
    while(queue.length){
        const { to, cost } = queue.pop();
        
        lines[to].forEach((next)=>{
            if(arr[next.to] > arr[to] + next.cost){
                arr[next.to] =  arr[to] + next.cost;
                queue.push(next);
            }
        })
    }
    
    return arr.filter((item) => item <= K).length;
}