class Node{
    constructor(idx, prev){
        this.idx = idx;
        this.prev = prev;
        this.next = null;    
    }
}

function solution(n, k, cmd) {
    let select; // 선택된 노드
    let prevNode = new Node(0);
    
    for(let i=1; i<n; i++){
        const newNode = new Node(i, prevNode);
        prevNode.next = newNode;
        prevNode = newNode;
        
        if(i===k){
            select = newNode;
        }
    }
    
    const deleteArr = [];
    
    const move = (num, dir) => {
        for(let i=0; i<num; i++){
            if(!select[dir]) break;
            select = select[dir];
        }
    }
    
    const deleteNode = () => {
        const prev = select.prev;
        const next = select.next;
        
        deleteArr.push(select);
        
        select = next ? next : prev; // 다음 노드가 있으면 next, 없으면 prev
        
        if(prev) prev.next = next;
        if(next) next.prev = prev;
    }
    
    const recoverNode = () => {
        const target = deleteArr.pop();
        
        const prev = target.prev;
        const next = target.next; 
        
        if(prev) prev.next = target;
        if(next) next.prev = target;
    }
    
    cmd.forEach((value)=>{
        const [c, num] = value.split(" ");
        
        switch(c){
            case "U":
                move(num, "prev");
                break;
            case "D":
                move(num, "next");
                break;
            case "C":
                deleteNode();
                break;
            case "Z": 
                recoverNode();
                break;
        }
    });

    const answer = Array(n).fill('O');
    deleteArr.forEach((node) => {
        answer[node.idx] = 'X';
    })
    
    return answer.join("");
}