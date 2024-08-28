// 트라이 노드를 나타내는 클래스
class Node {
    constructor(value = '') {
        this.value = value;  // 현재 노드의 문자 값
        this.count = 0;  // 현재 노드를 거쳐가는 단어의 수
        this.children = {};  // 자식 노드들을 저장하는 객체 (key: 문자, value: Node)
    }
}

// 트라이를 나타내는 클래스
class Trie {
    constructor() {
        this.root = new Node();  // 트라이의 root 노드 초기화
    }

    insert(word) {  // 단어 삽입 메서드
        let node = this.root;

        for (let i=0; i<word.length; i++) {  
            const char = word[i];
            if (!node.children[char]) node.children[char] = new Node(node.value + char);  // 해당 문자가 없으면 새로운 노드 생성 후 추가 
            node.count++;   // 현재 노드를 거치는 단어 수 증가 
            node = node.children[char];   // 다음 문자로 이동 
        }
        
        node.count++;   // 마지막 문자에 도달했을 때도 단어 수 증가 
    }

    search(query) {   // 쿼리 검색 메서드 
        let node = this.root;

        for (let i=0; i<query.length; i++) {
            const char = query[i];

            if (char === '?') return node.count;   // 와일드카트 '?'에 도달하면 현재까지의 단어 수 반환 
            
            if (!node.children[char]) return 0;   // 해당 문자가 없으면 매치되는 것 없으므로 0 반환 

            node = node.children[char];   // 다음 문자로 이동 
       }

       return 0;
   }
}

function solution(words, queries) {    
   const triesByLengthAscend  = Array.from({length:10001}, ()=>new Trie());     /* 정방향 트라이 배열 초기화 */
   const triesByLengthDescend  = Array.from({length:10001}, ()=>new Trie());     /* 역방향 트라이 배열 초기화 */

   words.forEach(word => { 
       triesByLengthAscend[word.length].insert(word); 
       triesByLengthDescend[word.length].insert([...word].reverse().join('')); 
   });

   return queries.map(query => query[0] === '?' ? 
           triesByLengthDescend[query.length].search([...query].reverse().join('')) : 
           triesByLengthAscend[query.length].search(query));
}