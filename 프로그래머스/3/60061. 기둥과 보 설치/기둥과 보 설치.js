// 기둥 체크
const colCheck = (ans, x, y) => {
    // 바닥 위에 존재하는 경우
    if(y === 0) return true;

    // 다른 기둥 위에 존재하는 경우
    if(ans.find(([a, b, type]) => a==x && b==y-1 && type===0)) return true;
    
    // 보의 왼쪽 끝부분인 경우
    if(ans.find(([a, b, type]) => a==x && b==y && type===1)) return true;

    // 보의 오른쪽 끝부분인 경우
    if(ans.find(([a, b, type]) => a==x-1 && b==y && type===1)) return true;

    return false;
}
    
// 보 체크
const rowCheck = (ans, x, y) => {
    // 왼쪽 부분이 기둥 위인 경우
    if(ans.find(([a, b, type]) => a==x && b==y-1 && type===0)) return true;

    // 오른쪽 부분이 기둥 위인 경우
    if(ans.find(([a, b, type]) => a==x+1 && b==y-1 && type===0)) return true;

    // 양쪽 끝 부분이 다른 보와 연결된 경우
    if(ans.find(([a, b, type]) => a==x-1 && b==y && type===1) && ans.find(([a, b, type]) => a==x+1 && b==y && type===1)) return true;

    return false;
}
    
const build = (ans, x, y, a) => {
    if(a){ // 보이면
        if(rowCheck(ans, x, y)){
            ans.push([x, y, a]);
        }
    }else{ // 기둥이면
        if(colCheck(ans, x, y)){
            ans.push([x, y, a]);
        }
    }
}
    
const destroy = (ans, x, y, frame) => {
  const copy = ans.slice();
  const idx = ans.findIndex(([a, b, type]) => a===x && b===y && type===frame);
  
  copy.splice(idx, 1);
  
  for(const frs of copy) {
    const [xpos, ypos, fr] = frs;
    
    if(fr) {
      if(!rowCheck(copy, xpos, ypos)) return;
    }
    else {
      if(!colCheck(copy, xpos, ypos)) return;
    }
  }
  
  ans.splice(idx, 1);       
}
    
function solution(n, build_frame) {
    const answer = [];
    
    build_frame.forEach((value)=>{
        const [x, y, a, b] = value;
        
        if(b){
            build(answer, x, y, a);
        }else{
            destroy(answer, x, y, a);
        }
    })
    
    answer.sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : a[1] !== b[1] ? a[1] - b[1] : a[2] - b[2]);
    
    return answer;
}