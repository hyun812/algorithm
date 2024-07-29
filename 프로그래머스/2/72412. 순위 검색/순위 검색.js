function solution(info, query) {
    var answer = [];
    
    const users = {};
    info.map((v)=>{
        const arr = v.split(" ");
        const score = Number(arr.pop());
        
        const key = arr.join("");
    
        users[key] ? users[key].push(score) : users[key] = [score];
    });
    Object.keys(users).forEach(key => users[key].sort((a, b) => a - b)); // 이분탐색을 위해 value 값 정렬

    query
        .map(q => q.split(/ and | |-/i) // ' and ' 또는 " " 또는 "-"로 split
        .filter(e=>e)) // 유효한 값만
        .forEach((q) => {
            const score = q.pop();
            const result = getResult(users, q, score);
            answer.push(result);
        })
    
    return answer;
}

function getResult(users, query, score) {
    const key = Object.keys(users);
    return key
            .filter(k => query.every(v => k.includes(v)))
            .reduce((acc, cur) => acc + binarySearch(users[cur], score), 0);
}

function binarySearch(arr, target) {
    let left = 0;
    let right = arr.length;
    let result = 0;
    
    while(left < right) {
        const mid = Math.floor((left + right) / 2);
        
        if (arr[mid] >= target) right = mid;
        else if (arr[mid] < target) left = mid + 1;
    }
    return arr.length -left; 
}