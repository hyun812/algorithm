function solution(relation) {
    let answer = 0;
    
    let idxArr = Array.from({length: relation[0].length}, (_, i) => i);
    let comb = [];
    
    for(let i=0; i<idxArr.length; i++){
        comb.push(...getCombinations(idxArr, i+1));
    }
    
    const minimal = [];
    for(const c of comb){
        
        // 최소성을 만족하는지 확인
        if(minimal.filter((item) => item.every(v => c.includes(v))).length !== 0) continue;
        
        const key = relation.map((v) => c.map(item => v[item]).join(""));
        
        if([...new Set(key)].length === relation.length){
            minimal.push(c);
            answer++;
        }
    }
    return answer;
}

function getCombinations(arr, selectNumber) {
    const results = [];
    if(selectNumber === 1) return arr.map((el) => [el]);
    
    arr.forEach((fixed, index, origin) => {
        const rest = origin.slice(index+1);
        const comb = getCombinations(rest, selectNumber - 1);
        const attached = comb.map((el) => [fixed, ...el]);
        results.push(...attached);
    })    
    return results;
}