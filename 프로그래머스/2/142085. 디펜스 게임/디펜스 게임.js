/*
    n 병사의 수
    k 무적권의 횟수
    enemy 적의 수 배열
*/

class Heap {
    constructor() {
        this.heap = [];
    }
    
    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
    }
    
    push(value) {
        const heap = this.heap;
        heap.push(value);
        let index = heap.length-1;
        let parent = Math.floor((index-1)/2);
        
        while(index > 0 && heap[index] < heap[parent]) {
            this.swap(index, parent);
            index = parent;
            parent = Math.floor((index-1)/2);
        }
    }
    
    pop() {
        const heap = this.heap;
        if(heap.length <= 1){
            return heap.pop();
        }
        
        const output = heap[0];
        heap[0] = heap.pop();
        let index = 0;
        
        while (index * 2 + 1 < heap.length) {
            let left = index * 2 + 1, right = index * 2 + 2, next = index;
          
            if (heap[next] > heap[left]) {
                next = left;
            }
          
            if (right < heap.length && heap[next] > heap[right]) {
                next = right;
            }

            if (next === index) {
                break;
            }
            this.swap(index, next);
          index = next;
        }
      return output;
    }
}

function solution(n, k, enemy) {
    
    let arr = new Heap();
    let capacity = 0;
 
    //k번째까지는 일단 무적권 쓰면 capacity의 고려 대상에서 제외
    enemy.slice(0,k).forEach((element)=>arr.push(element));
    for(let i=k; i<enemy.length; i++){
        arr.push(enemy[i]);
        let popNum = arr.pop();
        if(popNum+capacity > n){
            return i;
        }
        capacity += popNum;
    }

    return enemy.length;
}