function solution(food) {
    let res = '';
    
    for(let i=1; i<food.length; i++){
        let cnt = Math.floor(food[i]/2);
        res += String(i).repeat(cnt);
    }
    return res + '0' + [...res].reverse().join('');
}