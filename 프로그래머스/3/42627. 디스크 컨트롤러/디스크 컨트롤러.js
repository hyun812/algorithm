// 작업 소요시간이 짧은 것, 요청시간이 빠른것, 번호가 작은 것 순으로
// 한번시작하면 계속 작업 수행
// 반환 시간 = (요청부터 종료까지 걸린 시간)
// 반환 시간의 평균 정수부분을 반환

function solution(jobs) {
    const heap = new Heap();
    
    jobs.sort((a, b) => a[0] - b[0]);
    
    let time = 0; // 현재 시간
    let total = 0;
    let index = 0;
    
    while (index < jobs.length || heap.size()) {
        // 현재 시간보다 작거나 같은 작업이 존재하는 경우 큐에 추가
        while (index < jobs.length && jobs[index][0] <= time) {
            heap.push(jobs[index++]);
        }
        
        if (!heap.size()) {
            time = jobs[index][0];
        } else {
            const [start, duration] = heap.pop();
            time += duration;
            total += time - start;
        }
    }
    
    return Math.floor(total / jobs.length);
}

class Heap {
    constructor() {
        this.heap = [];
    }
    
    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]]
    }
    
    size() {
        return this.heap.length;
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
        
        while (this.heap[parent] && this.heap[parent][1] > this.heap[index][1]) {
            this.swap(index, parent);
            index = parent;
            parent = this.getParent(index);
        }
    }
    
    bubbleDown(index) {
        let left = this.getLeftChild(index);
        let right = this.getRightChild(index);
        
        let min = index;
        
        if (this.heap[left] && this.heap[left][1] < this.heap[min][1]) {
            min = left;
        }
        
        if (this.heap[right] && this.heap[right][1] < this.heap[min][1]) {
            min = right;
        }
        
        if (min === index) return;
        
        this.swap(min, index);
        this.bubbleDown(min);
    }
    
    push(value) {
        this.heap.push(value);
        this.bubbleUp();
    }
    
    pop() {
        if (!this.heap.length) return null;
        if (this.heap.length === 1) return this.heap.pop();
        
        const min = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown(0);
        
        return min;
    }
}