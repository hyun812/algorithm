function solution(gems) {
    let answer = [1, gems.length];
    const cnt = new Set(gems).size;
    
    let l = 0, r = 0;
    const hit = new Map();
    
    hit.set(gems[0], 1)
    
    while(r < gems.length){
        if(hit.size === cnt){ // 모든 보석이 포함되어 있다면 왼쪽을 늘려 나가면서 확인
            if(answer[1] - answer[0] > r-l)
                answer = [l+1, r+1];
            
            const left = gems[l];
            hit.set(left,  hit.get(left) - 1);
            if(!hit.get(left))
                hit.delete(left);
            
            l++;
        }else{
            r++;
            const right = gems[r];
            hit.set(right, hit.get(right) ? hit.get(right)+1 : 1);
        }
    }
    
    return answer;
}