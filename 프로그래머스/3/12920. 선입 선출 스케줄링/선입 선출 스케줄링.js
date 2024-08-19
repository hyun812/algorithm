function solution(n, cores) {
    const len = cores.length;
    
    let left = 1;
    let right = Math.max(...cores) * n;
    
    while(left < right){
        let mid = ~~((left + right) / 2);
        
        // mid 시간동안 코어가 처리할 수 있는 작업의 수
        const capacity = cores.reduce((acc, cur) => acc + ~~(mid/cur), 0) + len;
        if(capacity >= n){
            right = mid;
        }else {
            left = mid + 1;
        }
    }
    
    // 처리할 수 있는 모든 작업의 수
    let work = cores.reduce((acc, cur) => acc + ~~(left/cur), 0) + len;
    let ret = [];
    for(let i=0; i<len; i++){
        // 마지막 시간에 진행될 수 있는 작업
        if(!(left%cores[i])) ret.push(i+1);
    }
    return ret[ret.length-work+n-1];
}
