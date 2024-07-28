function solution(data, col, row_begin, row_end) {
    var answer = 0;
    
    data.sort((a, b) => {
        return a[col-1] === b[col-1] ? b[0] - a[0] : a[col-1] - b[col-1];
    })
    
    for(let i=row_begin-1; i<row_end; i++){
        answer ^= data[i].map((v)=>v%(i+1)).reduce((acc, cur)=> acc+cur, 0);
    }
    
    return answer;
}