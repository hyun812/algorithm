function solution(s) {
    const answer = [];
    const arr = JSON.parse(s.replace(/{/g, "[").replace(/}/g, "]"));
    
    arr.sort((a, b) => a.length - b.length);
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length; j++) {
            if (!answer.includes(arr[i][j])) answer.push(arr[i][j]);
        }
    }
    
    return answer
}