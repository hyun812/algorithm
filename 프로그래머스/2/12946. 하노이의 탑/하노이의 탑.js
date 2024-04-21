// 1번에 있는 n개의 원판을 3번으로 옮기는 최소 개수
function solution(n) {
    const answer = [];
    
    const hanoi = (n, from, to, by) => {
        if(n==1){
            answer.push([from, to]);
            return;
        }
        
        hanoi(n-1, from, by, to);  // 1에 있는걸 2로 옮김 (가장 밑 빼고)
        answer.push([from, to]); // 1에 남아 있는 가장 큰 원반을 3으로 옮김
        hanoi(n-1, by, to, from); // 2에 옮겨뒀던 원판을 3으로 옮김
    }
    hanoi(n, 1, 3, 2);
    return answer;
}

/*
    1 -> [1,3]
    2 -> [1,2] [1,3] [2,3]
    3 -> [1,2] [1,2] [1,3] [2,3] [2,3]

*/