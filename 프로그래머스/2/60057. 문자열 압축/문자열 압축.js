function solution(s) {
  let answer = s.length;

  for (let i = 1; i <= Math.floor(s.length / 2); i++) {
    let str = ""; // 압축한 문자열
    let cnt = 1; // 압축한 횟수
    let tempStr = s.substr(0, i); // 압축하는 기준 문자열
     
    for (let idx = i; idx < s.length; idx += i) {
      let nextStr = s.substr(idx, i);
        
      if (tempStr === nextStr) {
        cnt += 1;
      } else {
        if (cnt === 1) str = str + tempStr;
        else str = str + cnt + tempStr;

        cnt = 1;
        tempStr = nextStr;
      }
    }
      
    if (cnt === 1) str = str + tempStr;
    else str = str + cnt + tempStr;
      
    answer = Math.min(answer, str.length);
  }

  return answer;
}