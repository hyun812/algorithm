function solution(operations) {
    const heap = [];
    
    for (const operation of operations) {
        const [type, num] = operation.split(' ');
        const number = Number(num);
        
        if (type === 'I') {
            heap.push(number);
        } else {
            const find = number === 1 ? Math.max(...heap) : Math.min(...heap);
            const deleteIndex = heap.indexOf(find);
            
            heap.splice(deleteIndex, 1);
        }
    }
    
    if (!heap.length) return [0, 0];
    
    heap.sort((a, b) => a - b);
    return [heap[heap.length - 1], heap[0]];
}