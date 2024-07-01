function solution(genres, plays) {
    var answer = [];

    let song = genres.map((value, index)=>{
        return {
            idx: index,
            genre: value,
            play: plays[index],
        }
    })
    
    let genreCnt = [];
    
    song.forEach((s) => {
        let thisGenre = genreCnt.find((g) => g.genre === s.genre);
                
        if(thisGenre){
            thisGenre.play += s.play;
        }else{
            genreCnt.push({
                genre: s.genre,
                play: s.play,
            })
        }  
    })
    
    song.sort((a,b) => b.play - a.play);
    genreCnt.sort((a, b) => b.play - a.play);
    
    genreCnt.forEach((g) => {
        let len = 0;
        song.forEach((s) => {
            if(g.genre === s.genre && len < 2){
                len++;
                answer.push(s.idx);
            }
        })
    })
    
    return answer;
}