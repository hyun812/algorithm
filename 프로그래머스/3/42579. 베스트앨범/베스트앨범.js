function solution(genres, plays) {
    const answer = [];
    
    const map = new Map();
    const genreMap = new Map();
    for (let i = 0; i < genres.length; i++) {
        const genre = genres[i];
        const play = plays[i];
        
        genreMap.set(genre, (genreMap.get(genre) || 0) + play);
        
        if (map.has(genre)) {
            const value = map.get(genre);
            value.push([i, play]);
            map.set(genre, value);
        } else {
            const arr = [i, play];
            map.set(genre, [arr]);
        }
    }
    
    const sortArr = Array.from(genreMap).sort((a, b) => b[1] - a[1]);
    
    for (const [genre, ] of sortArr) {
        const value = map.get(genre);
        const convert = value.sort((a, b) => b[1] - a[1]).splice(0, 2).forEach(v => answer.push(v[0]));
    }
    
    
    return answer;
}