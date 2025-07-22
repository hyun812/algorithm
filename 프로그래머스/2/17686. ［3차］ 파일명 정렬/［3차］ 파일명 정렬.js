function solution(files) {
    const sortArr = [];
    for (let i = 0; i < files.length; i++) {
        let head = "";
        let number = "";
        
        let isTail = false;
        for (const char of files[i]) {
            if (isNaN(char) || char === ' ') {
                if (isTail) break;
                head += char;
            } else {
                number += char;
                isTail = true;
            }
        }
        
        sortArr.push([head.toLowerCase(), Number(number), i])        
    }
    
    sortArr.sort((a, b) => {
        if (a[0] !== b[0]) {
            return a[0].localeCompare(b[0]);
        } else if (a[1] !== b[1]){
            return a[1] - b[1];
        } else {
            return 0;
        }
    });

    return sortArr.map((v) => files[v[2]]);
}