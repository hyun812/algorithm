const comb = [
    ["+", "*", "-"],
    ["+", "-", "*"],
    ["*", "+", "-"],
    ["*", "-", "+"],
    ["-", "*", "+"],
    ["-", "+", "*"],
];

function solution(expression) {
    let answer = 0;
    
    let numbers = [];
    let operators = [];
    let num = "";
    for(let i=0; i<expression.length; i++){
        const target = expression[i];
        if(target === '+' || target === '-' || target === '*'){
            operators.push(target);
            numbers.push(Number(num));
            num = "";
        }else{
            num += target;
        }
    }
    numbers.push(Number(num));
    
    comb.forEach((c) => {
        let copyNums = numbers.slice();
        let copyOper = operators.slice();
        
        c.forEach(oper => {
            let idx = copyOper.indexOf(oper);
            while(idx !== -1) {
                copyNums[idx] = calculator(copyNums[idx], copyNums[idx+1], oper);
                copyNums.splice(idx+1, 1);
                copyOper.splice(idx, 1);
                idx = copyOper.indexOf(oper);
            }
        })
        // 절댓값을 취해서 최댓값 갱신 여부를 판단한다.
        answer = Math.max(answer, Math.abs(copyNums[0]));
    })
    return answer;
}


function calculator(a, b, oper) {
    if (oper === "+") return a + b;
    if (oper === "*") return a * b;
    if (oper === "-") return a - b;
}