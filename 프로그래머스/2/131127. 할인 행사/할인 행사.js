// 10일 연속 일치할 경우에 맞춰서 회원가입 진행
function solution(want, number, discount) {
    let answer = 0;
    
    const map = new Map();
    for (let i = 0; i < want.length; i++) {
        map.set(want[i], number[i]);
    }
    
    for (let i = 0; i <= discount.length - 10; i++) {
        const copy = new Map([...map]);
        
        let count = 0;
        for (let j = i; j < i + 10; j++) {
            const target = discount[j];
            
            if (!copy.has(target)) break;
            if (!copy.get(target)) break;
            
            copy.set(target, copy.get(target) - 1);
            count++;
        }
        
        if (count === 10) answer++;
    }
    return answer;
}