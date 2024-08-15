function solution(babbling) {
    let answer = 0;
    const words = ['aya','ye','woo','ma'];
    
    babbling.forEach((v) => {
        for(let word of words){
            if(v.includes(word.repeat(2))) break;
            v = v.replaceAll(word, " ");
        }
        if(!v.replaceAll(" ", "")) answer++;
    })
    return answer;
}