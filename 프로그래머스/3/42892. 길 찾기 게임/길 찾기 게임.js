class Node {
    constructor(value, x){
        this.value = value;
        this.x = x;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    
    constructor(){
        this.root = null;
    }
    
    insert(value, x) {
        const newNode = new Node(value, x);
        
        this.root ? this.inserNode(this.root, newNode) : this.root = newNode;
    }
    
    inserNode(node, newNode){
        if(newNode.x < node.x){
            node.left ? this.inserNode(node.left, newNode) : node.left = newNode;
        }else{
            node.right ? this.inserNode(node.right, newNode) : node.right = newNode;      
        }
    }
    
    preOrder(node = this.root, result = []) {
        if(node){
            result.push(node.value);
            this.preOrder(node.left, result);
            this.preOrder(node.right, result);
        }
        return result;
    }
    
    postOrder(node = this.root, result = []) {
        if(node){
            this.postOrder(node.left, result);
            this.postOrder(node.right, result);
            result.push(node.value);
        }
        return result;
    }
}

function solution(nodeinfo) {
    
    const nodes = nodeinfo.map((node, idx)=>{
        return [idx+1, node[0], node[1]];
    }).sort((a,b)=> b[2] - a[2]); // y축좌표 기준으로 정렬
    
    const tree = new BinaryTree();
    nodes.forEach((node) => {
        tree.insert(node[0], node[1]);
    })
    
    return [tree.preOrder(), tree.postOrder()];
}