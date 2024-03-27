// 만들 수 있는 소수의 개수 구하기

function solution(numbers) {
    let answer = 0;

    const arr = numbers.split('');
    const num = Array.from({length: numbers.length} , ()=>0);
    const visited = Array.from({length: numbers.length} , ()=>0);
    
    const dfs = (number) => {
        num.push(+number);
        for(let i=0; i<arr.length; i++){
            if(visited[i]) continue;
            
            visited[i] = 1;
            dfs(number+numbers[i]);
            visited[i] = 0;
        }
    }
    
    dfs("");
    
    
    return [...new Set(num)].filter(v=>isPrime(v)).length;
}

const isPrime = (n) =>{
    if(n <= 1) return false;
    
    for(let i=2; i<=Math.sqrt(n); i++){
        if(n % i == 0){
            return false;
        }
    }
    return true;
}

