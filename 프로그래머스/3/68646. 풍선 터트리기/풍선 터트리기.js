function solution(a) {
    let minL = a[0];
    let minR = a[a.length-1];
    const leftA = [];
    const rightA = [];
    
    for(let i=1; i<a.length - 1; i++){ // 양쪽 제외 후 탐색
        let curL = a[i]; 
        if(curL < minL){
            minL = curL;
            leftA.push(curL);
        }
        
        let curR = a[a.length-1-i];
        if(curR < minR){
            minR = curR;
            rightA.push(curR);
        }
    }

    return [...new Set([...leftA, ...rightA])].length + 2;
}