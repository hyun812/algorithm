function solution(sticker) {
    const len = sticker.length;
    
    const dp1 = new Array(len).fill(0); // 첫 번째 스티커를 뗄 경우
    const dp2 = new Array(len).fill(0); // 첫 번째 스티커를 떼지 않을 경우
  
    dp1[0] = sticker[0];
    dp1[1] = sticker[0];
    dp2[1] = sticker[1];
    
    for(let i=2; i<len; i++){
        if(i === len -1){ // 마지막 스티커라면 dp1은 사용하지 못함
            dp1[i] = dp1[i-1];
        }else{
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);    
        }
        dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
    }
    
    return Math.max(dp1[len-1], dp2[len-1]);
}