class Heap {
    constructor() {
        this.heap = [];
    }
    
    size() {
        return this.heap.length;
    }
    
    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]]
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
        
        while (this.heap[parent] && this.heap[index] > this.heap[parent]) {
            this.swap(index, parent);
            index = parent;
            parent = this.getParent(index);
        }
    }
    
    bubbleDown(index) {
        let left = this.getLeftChild(index);
        let right = this.getRightChild(index);
        
        let minIdx = index;
        
        if (this.heap[left] && this.heap[left] > this.heap[minIdx]) {
            minIdx = left;
        }
        
        if (this.heap[right] && this.heap[right] > this.heap[minIdx]) {
            minIdx = right;
        }
        
        if (minIdx === index) return;
        
        this.swap(minIdx, index);
        this.bubbleDown(minIdx);
    }
    
    push(data) {
        this.heap.push(data);
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

function solution(n, works) {
    if (n >= works.reduce((acc, cur) => acc + cur, 0)) return 0;
    
    const heap = new Heap();
    for (let i = 0; i < works.length; i++) {
        heap.push(works[i]);
    }

    for (let i = 0; i < n; i++) {
        let peek = heap.pop() - 1;
        heap.push(peek);
    }
    
    const answer = heap.heap.reduce((acc, cur) => acc + cur ** 2, 0);
    return answer
}