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
        
        while (this.heap[parent] && this.heap[parent] < this.heap[index]) {
            this.swap(index, parent);
            index = parent;
            parent = this.getParent(index);
        }
    }
    
    bubbleDown(index) {
        let left = this.getLeftChild(index);
        let right = this.getRightChild(index);

        let maxIdx = index;

        if (left < this.heap.length && this.heap[left] > this.heap[maxIdx]) {
            maxIdx = left;
        }
        if (right < this.heap.length && this.heap[right] > this.heap[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx === index) return;

        this.swap(maxIdx, index);
        this.bubbleDown(maxIdx);
    }
    
    push(value) {
        this.heap.push(value);
        this.bubbleUp();
    }
    
    pop() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();
        
        const max = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown(0);
        return max;
    }
    
    peek() {
        return this.heap[0];
    }
}

function solution(n, k, enemy) {
    const heap = new Heap();
    let answer = 0;
    for (let i = 0; i < enemy.length; i++) {
        heap.push(enemy[i]);
        n -= enemy[i];
        
        if (n < 0) {
            if (k === 0 || n + heap.peek() < 0) return answer;
            k--;
            n += heap.pop();
        }
        answer += 1;
    }
    
    return answer;
}