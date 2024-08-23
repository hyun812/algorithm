class Node {
    constructor(value = "", numOfWords = 0) {
        this.value = value;
        this.numOfWords = numOfWords
        this.child = new Map();
    }
}

class Trie {
    constructor() {
        this.root = new Node();
    }

    insert(word) {
        let cur_node = this.root;

        for (const char of word) {
            if (!cur_node.child.has(char)) {
                cur_node.child.set(char, new Node(cur_node.value + char));
            }
            cur_node = cur_node.child.get(char);
            cur_node.numOfWords += 1;
        }
    }
    
    getCount(word) {
        let cur_node = this.root;
        let len = 0;    
        
        for(const char of word) {
            cur_node = cur_node.child.get(char);
            len++;
            if(cur_node.numOfWords === 1) return len;
        }
        return len;
    }
}

function solution(words) {
    const trie = new Trie();
    words.forEach((item) => trie.insert(item));
    return words.map((item) => trie.getCount(item)).reduce((acc, cur) => acc + cur, 0);
}