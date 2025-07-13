// 모두 공집합이면 1
// 교집합의 개수 / 합집합의 개수
// 원소의 중복을 허용함 (교집합은 min , 합집합은 max)
function solution(str1, str2) {
    let answer = 0;
    
    const makeArr = (str) => {
        const results = [];
        for (let i = 0; i < str.length - 1; i++) {
            const item = str[i] + str[i+1];
            if (item.match(/^[a-zA-Z]+$/)) {
                results.push(item.toLowerCase());
            }
        }
        return results;
    }
    
    const arr1 = makeArr(str1);
    const arr2 = makeArr(str2);
    const set = new Set([...arr1, ...arr2]);
    
    let intersection = 0;
    let union = 0;
    
    set.forEach((item) => {
        const has1 = arr1.filter(v => v === item).length;
        const has2 = arr2.filter(v => v === item).length;
        
        intersection += Math.min(has1, has2);
        union += Math.max(has1, has2);
    })
    
    if (!intersection && !union) return 65536;
    return Math.floor(intersection / union * 65536);
}