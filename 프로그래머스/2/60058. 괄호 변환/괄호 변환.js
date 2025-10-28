// 개수가 같으면 균형잡힌 괄호 문자열

function solution(p) {    
    const checkCorrect = (words) => {
        const temp = [];
        for (const char of words) {
            if (char === '(') {
                temp.push(char);
            } else {
                if (temp[temp.length - 1] === '(') {
                    temp.pop();
                } else {
                    return false;
                }
            }
        }
        if (temp.length) return false;
        return true;
    }
    
    const conversionWords = (p) => {
        if (p === '') return p;
        if (checkCorrect(p)) return p;
        
        let open = 0;
        let close = 0;
        for (const char of p) {
            if (open !== 0 && open === close) break;
            char === '(' ? open++ : close++;
        }

        let u = p.slice(0, open + close);
        let v = p.slice(open + close);
        
        if (checkCorrect(u)) {
            return u + conversionWords(v)
        } else {
            let newV = '(' + conversionWords(v) + ')';
            
            for (let i = 1; i < u.length - 1; i++) {
                newV += u[i] === '(' ? ')' : '(';
            }
            return newV;
        }
    }
    
    return conversionWords(p);
}