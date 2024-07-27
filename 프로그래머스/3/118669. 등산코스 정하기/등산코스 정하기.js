/*
    n: 산 지점 수
    paths: 각 등산로의 정보 2차원 배열
    gates: 출입구의 번호
    summits: 산봉우리들의 번호
*/
function solution(n, paths, gates, summits) {
    const isSummit = new Set(summits);

    const graph = Array.from({length: n+1} , () => []);
    for(const [i, j, w] of paths) {
        graph[i].push([j, w]);
        graph[j].push([i, w]);
    }
    
    const queue = new Heap();
    const intensity = new Array(n+1).fill(Infinity);
    
    for(const gate of gates){
        queue.add([gate, 0]);
        intensity[gate] = 0;
    }
    
    while(queue.size()){
        const [cur, curWeight] = queue.poll();
         
        if(isSummit.has(cur)) continue;
        if(intensity[cur] < curWeight) continue;
        
        for(const [next, nextWeight] of graph[cur]){
            const newWeight = Math.max(curWeight, nextWeight);
            
            if(newWeight < intensity[next])  {
                intensity[next] = newWeight;
                queue.add([next, newWeight]);
            }
        }
    }
    
    let answer = [0, Infinity];
    summits.sort((a, b) => a-b);
    for(const s of summits) {
        if(intensity[s] < answer[1]){
            answer = [s, intensity[s]];
        }
    }
    
    return answer;
}

class Heap {
    constructor() {
        this.heap = [];
    }
    
    size() {
        return this.heap.length;    
    }
    
    swap(a,b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
    }
    
    getParent(index) {
        return Math.floor((index - 1) / 2)        
    }
    
    getLeftChild(index) {
        return index * 2 + 1
    }
    
    getRightChild(index) {
        return index * 2 + 2
    }
    
    bubbleUp() {
        let index = this.heap.length - 1;
        let parent = this.getParent(index);
        
        while (this.heap[parent] && this.heap[index] < this.heap[parent]) {
            this.swap(index, parent);
            index = parent;
            parent = this.getParent(parent);
        }
    }
    
    bubbleDown(index) {
        let left = this.getLeftChild(index);
        let right = this.getRightChild(index);
        
        let minIdx = index;
        
        if(this.heap[left] && this.heap[left] < this.heap[minIdx]){
            minIdx = left;
        }
        
        if(this.heap[right] && this.heap[right] < this.heap[minIdx]){
            minIdx = right;
        }
        
        if(minIdx === index) return;
        
        this.swap(minIdx, index);
        this.bubbleDown(minIdx);
    }
    
    add(value) {
        this.heap.push(value);
        this.bubbleUp();
    }
    
    poll() {
        if(this.size() === 0) return;
        
        if(this.size() === 1) {
            return this.heap.pop();
        }
        
        const min = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown(0);
        
        return min;
    }
}