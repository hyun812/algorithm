function solution(orders, course) {
    var answer = [];
    
    const getCombinations = (arr, selectNum) => {
        const results = [];
        
        if (selectNum === 1) return arr.map(el => [el]);
        
        arr.forEach((fixed, index, origin) => {
            const rest = origin.slice(index + 1);
            const combinations = getCombinations(rest, selectNum - 1);
            const attached = combinations.map(el => [fixed, ...el].sort().join(''));
            
            results.push(...attached);
        })
        
        return results;
    }
    
    for (const cou of course) {
        const map = new Map();
        
        let max = 0;
        for (const order of orders) {
            const results = getCombinations(order.split(''), cou);
            results.forEach(v => {
                map.set(v, (map.get(v) || 0) + 1);
                max = Math.max(max, map.get(v));
            })
        }
        
        for (const [key, value] of map) {
            if (value === max && max > 1) answer.push(key);    
        }
    }
    
    
    return answer.sort();
}