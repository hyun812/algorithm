function solution(array) {
    var answer = 0;
    let map = new Map();
    
    for(let i=0; i<array.length; i++){
        map.set(array[i], (map.get(array[i]) || 0) + 1);
    }
    console.log(map);
    console.log([...map]);
    ar = [...map].sort((a,b) => b[1]-a[1]);
    console.log(ar);
    
    if(ar.length === 1){
        return ar[0][0];
    }
    return  ar[0][1] == ar[1][1] ? -1 : ar[0][0];;
}