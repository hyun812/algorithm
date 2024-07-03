// 요청되는 시점, 작업의 소요시간 주어짐
function solution(jobs) {
    let answer = 0;
    
    const len = jobs.length;
    let time = 0; // 현재 시간
    let complete = 0; // 한 작업이 완료되고 나서의 시간
    
    jobs.sort((a, b) => a[0] - b[0]);
    const heap = new Heap();
    
    while(jobs.length || heap.size()){
        // 현재 시간과 요청시간이 같다면 모든 요청을 큐에 넣음
        while(jobs.length && jobs[0][0] === time){
            heap.push(jobs.shift());
        }
        // 큐가 비어있지 않고 
        // 현재시간이 한 작업이 완료되고 나서의 시간보다 크거나같다면
        if(heap.size() && time >= complete){
            const pop = heap.pop();
            complete = pop[1] + time;
            answer += complete - pop[0];
        }
        time++;
    }
    
    return Math.floor(answer/len);
}


class Heap {
    constructor() {
        this.heap = [];
    }
    
    size() {
        return this.heap.length;
    }
    
    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
    }
    
    getParent(index) {
        return Math.floor((index - 1) / 2);
    }

    getLeftChild(index) {
        return index * 2 + 1;
    }

    getRightChild(index) {
        return index * 2 + 2;
    }
    
    
    bubbleUp() {
        let index = this.heap.length - 1;
        let parent = this.getParent(index);
        
        // 부모 노드가 존재하고, 새로운 노드가 부모 노드보다 작은 경우
        while(this.heap[parent] && this.heap[index][1] < this.heap[parent][1]){
            this.swap(parent, index);
            index = parent;
            parent = this.getParent(index);
        }
    }
    
    bubbleDown(index){
        let left = this.getLeftChild(index);
        let right = this.getRightChild(index);
        
        let minIdx = index;

        // 왼쪽 자식 노드가 존재 하면서 값이 루트 노드보다 작거나
        if (left < this.heap.length && this.heap[left][1] < this.heap[minIdx][1]) {
            minIdx = left;
        }
        // 오른쪽 자식 노드가 존재 하면서 값이 루트 노드보다 작은 경우
        if (right < this.heap.length && this.heap[right][1] < this.heap[minIdx][1]) {
            minIdx = right;
        }

        // 내가 젤 작음
        if (minIdx === index) return;

        this.swap(minIdx, index);
        this.bubbleDown(minIdx);
    }
    
    
    push(value) {
        this.heap.push(value);
        this.bubbleUp();
    }
    
    pop() {
        if (this.heap.length === 0) return;

        if (this.heap.length === 1) {
            return this.heap.pop();
        }

        const min = this.heap[0];
        this.heap[0] = this.heap.pop(); // 제일 뒤에 있는 원소를 제일 앞으로
        this.bubbleDown(0);

        return min;
    }
}



