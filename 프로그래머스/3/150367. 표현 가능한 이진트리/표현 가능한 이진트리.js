function solution(numbers) {
    const answer = [];
    
    for(let number of numbers){
        const bi = number.toString(2);
        const n = bi.length;
        const m = n.toString(2).length; // 높이
        
        // 포화이진트리 형태로 앞에 0을 채움
        const tree = bi.padStart(2**m -1, "0");
        check(tree, 0, tree.length-1) ? answer.push(1) : answer.push(0);
    }
    
    return answer;
}

function check (tree, start, end) {
    const parent = Math.floor((start+end) / 2);
    const left = Math.floor((start + parent-1)/2);
    const right = Math.floor((parent+1 + end)/2);
    
    if (start == end) return true;
    
    //부모가 0 인데 자식이 1이라면
    if (tree[parent] === '0' && ((tree[left] === '1') || (tree[right] === '1'))) {
        return false;
    }

    if (!check(tree, start, parent-1)) return false;
    if (!check(tree, parent+1, end)) return false;
    
    return true;
}