function solution(priorities, location) {
    let answer = 1;
    
    const priority = [...priorities].sort((a, b) => b - a);
    
    const convert = priorities.map((p, i) => {
        return { p: p, i: i }
    });
    

    while (convert.length) {
        const { p, i } = convert.shift();
        
        if (priority[0] > p) {
            convert.push({p, i});
        }else {
            if (i === location) return answer;
            priority.shift();
            answer++;    
        }
    }
    
    return answer;
}