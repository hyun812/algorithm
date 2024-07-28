function solution(users, emoticons) {
    var answer = [];
    
    const permutations = getPermutations([10, 20, 30, 40], emoticons.length);

    permutations.forEach((permutation) => {
        let count = 0;
        const costs = Array(users.length).fill(0);
        
        permutation.forEach((perm, idx) => {
            for(let i=0; i<users.length; i++){
                if(users[i][0] <= perm){
                    costs[i] += emoticons[idx] * (100-perm) / 100;
                }
            }
        })
        let price = 0;
        costs.forEach((cost, idx) => {
            if(cost >= users[idx][1]){ 
                count++;
            }else{
                price += cost;
            }
        })
        
        answer.push([count, price]);
    })
    
    answer.sort((a,b) => {
        return a[0] !== b[0] ? b[0] - a[0] : b[1] - a[1];
    })
    
    return answer[0];
}


function getPermutations(arr, selectNumber) { // 중복 순열
    const result = [];

    if (selectNumber === 1) return arr.map((el) => [el]);

    arr.forEach((fixed, index, origin) => {
        const permutations = getPermutations(origin, selectNumber - 1); 
        const attached = permutations.map((el) => [fixed, ...el]); 
        
        result.push(...attached); 
    });
    
  return result;
}