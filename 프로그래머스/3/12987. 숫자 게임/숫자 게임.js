function solution(A, B) {
    let answer = 0;
    // 7 5 3 1
    // 8 6 2 2
    
    A.sort((a, b) => b-a);
    B.sort((a, b) => b-a);
    
    let aIdx = 0;
    let bIdx = 0;
    
    while(true){
        if(aIdx === A.length || bIdx === B.length) break;
        const aScore = A[aIdx];
        const bScore = B[bIdx];
        
        if(bScore > aScore){
            answer++;
            aIdx++;
            bIdx++;
        }else{
            aIdx++;
        }
    }

    return answer;
}