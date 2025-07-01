function solution(cacheSize, cities) {
    let answer = 0;
    
    const cache = [];
    if (cacheSize === 0) return cities.length * 5;
    
    for (const city of cities) {
        const lower_city = city.toLowerCase();
        
        if (cache.includes(lower_city)) {
            cache.splice(cache.indexOf(lower_city), 1);
            cache.push(lower_city);
            answer += 1;
        }else {
            if (cache.length === cacheSize) {
                cache.shift();
            }
            cache.push(lower_city);
            answer += 5;
        }
    }
    
    return answer;
}