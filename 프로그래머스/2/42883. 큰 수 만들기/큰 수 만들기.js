function solution(number, k) {
    const arr = [];
    for (let i = 0; i < number.length; i++) {
        const target = number[i];
        
        while(arr && arr[arr.length-1] < target && k>0){
            k--;
            arr.pop();      
        }
        arr.push(target);
    }
    arr.splice(number.length - k, k);
    return arr.join("");    
}