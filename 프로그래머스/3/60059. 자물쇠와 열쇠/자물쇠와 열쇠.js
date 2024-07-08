//키를 회전하는 함수
const rotationKey = (key) => {
    const len = key.length;
    const rotate = Array.from(Array(len), () => Array(len).fill(null));
    
    for (let i = 0; i < len; ++i) {
        for (let j = 0; j < len; ++j) {
            rotate[i][j] = key[len - j - 1][i];
        }
    }
    return rotate;
};

const check = (arr, n) => {
    for(let i=n; i<n*2; i++){
        for(let j=n; j<n*2; j++){
            if(arr[i][j] !== 1) return false;
        }
    }
    return true;
}

function solution(key, lock) {
    
    const len = lock.length;
    const arr = Array.from({length: len*3}, () => Array(len*3).fill(null)); // 자물쇠를 3배 확장
    
    for(let i=len; i<len*2; i++){
        for(let j=len; j<len*2; j++){
            arr[i][j] = lock[i-len][j-len];
        }
    }
    
    for(let i=0; i<4; i++){ // 키를 회전
        key = rotationKey(key);
    
        for(let j=0; j<=arr.length - key.length; j++){
            for(let k=0; k<=arr[0].length - key[0].length; k++){ // 키를 이동
                
                const copy = arr.map((arr) => arr.slice()); // 자물쇠 배열 copy
                
                for(let n=0; n<key.length; n++){
                    for(let m=0; m<key.length; m++){
                        copy[j+n][k+m] = arr[j+n][k+m] + key[n][m]; // 키의 값과 자물쇠을 더함
                    }
                }
                // 값이 모두 1이라면 정확히 들어맞는 경우임
                if(check(copy, len)) {
                    return true;
                }
            }
        }
    }
    
    return false;
}