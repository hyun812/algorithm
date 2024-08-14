function solution(name, yearning, photo) {
    const answer = [];
    
    const map = new Map();
    for(let i=0; i<name.length; i++){
        map.set(name[i], yearning[i]);
    }
    
    photo.forEach((memory) => {
        let score = 0;
        memory.forEach(v=>{
            score += (map.get(v) || 0);
        })
        
        answer.push(score);
    })
    
    return answer;
}