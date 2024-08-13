function solution(food) {
    let arr = [];
    
    food.slice(1).reverse().forEach((v, index) => {
        let cnt = (v % 2 === 0) ? v : v - 1;
        const num = (index - food.length + 1) * -1;
        
        for(let i=0; i<cnt/2; i++){
            arr = [...[num], ...arr, ...[num]];
        }
    })
    
    arr = [...arr.slice(0, arr.length/2), 0, ...arr.slice(arr.length/2)];
    
    return arr.join('');
}