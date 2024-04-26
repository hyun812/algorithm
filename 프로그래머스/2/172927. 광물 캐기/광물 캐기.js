/*
    광물 5개를 캔 후에는 더 이상 사용할 수 없음
    1번 시작하면 사용 할 수 없을 때까지 사용
    광물은 주어진 순서대로 캐야함
    모든 광물을 캐거나 더 사용할 곡괭이 없을때까지
    최소한의 피로도
*/
function solution(picks, minerals) {
    let answer = 0;
        
    minerals = minerals.splice(0, picks.reduce((a,b) => a+5*b, 0));
    const fatigue = [{'diamond' : 1 , 'iron' : 1 , 'stone' : 1},
                     {'diamond' : 5 , 'iron' : 1 , 'stone' : 1},
                     {'diamond' : 25 , 'iron' : 5 , 'stone' : 1}]
    
    const arr = [];
    for(let i=0; i<minerals.length; i+=5){
        arr.push(minerals.slice(i, i+5));
    }
        
    
    arr.sort((a,b) => {
        const aDiaCnt = a.filter(el => el === 'diamond').length;
        const bDiaCnt = b.filter(el => el === 'diamond').length;
        
        if(aDiaCnt === bDiaCnt) {
            const aIronCnt = a.filter(el => el === 'iron').length;
            const bIronCnt = b.filter(el => el === 'iron').length;
          return bIronCnt - aIronCnt
        }
        return bDiaCnt-aDiaCnt
    })
    
    let i= picks[0] ? 0 : picks[1] ? 1 : 2;
    
    for (const mine of arr){
        answer += mine.reduce((a,c) => a+fatigue[i][c],0)
        if (--picks[i]<=0) i++
        if (picks.every(el => !el)) return answer
        
    }
    return answer;
}