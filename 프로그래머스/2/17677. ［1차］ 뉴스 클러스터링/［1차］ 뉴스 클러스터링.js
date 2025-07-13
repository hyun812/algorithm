// 모두 공집합이면 1
// 교집합의 개수 / 합집합의 개수
// 원소의 중복을 허용함 (교집합은 min , 합집합은 max)
function solution(str1, str2) {
    let answer = 0;
    const a = new Map();
    const b = new Map();
    
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    for (let i = 0; i < str1.length - 1; i++) {
        const str = str1[i] + str1[i+1];
        if (isEnglish(str)) a.set(str, (a.get(str) || 0) + 1);
    }
    
    for (let i = 0; i < str2.length - 1; i++) {
        const str = str2[i] + str2[i+1];
        if (isEnglish(str)) b.set(str, (b.get(str) || 0) + 1);
    }
    
    if (!a.size && !b.size) return 65536;
    
    // 교집합
    let intersection = 0;
    for (const [key, value] of a) {
        if (!b.has(key)) continue;
        intersection += Math.min(value, b.get(key));
    }
    
    // 합집합
    let union = 0;
    const visited = new Set();
    for (const [key, value] of a) {
        if (b.has(key)) {
            union += Math.max(value, b.get(key));
            visited.add(key);
        }else {
            union += value;
        }
    }
    for (const [key, value] of b) {
        if (visited.has(key)) continue;
        union += value;
    }
    
    return Math.floor(intersection / union * 65536);
}

function isEnglish(str) {
  return /^[a-zA-Z]+$/.test(str);
}