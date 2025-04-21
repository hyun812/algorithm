function solution(s) {
    var answer = [0, 0];
    
    while (true) {
        if (s.length === 1) break;
        const re = s.replaceAll('0', '');
        answer[0]++;
        answer[1] += s.length - re.length;
        
        s = re.length.toString(2);
    }
    
    
    return answer;
}