function solution(points, routes) {
    const robotPath = new Map();
    
    const getPath = (start, end) => {
        const [r1, c1] = points[start - 1];
        const [r2, c2] = points[end - 1];
        
        const path = [];
        let r = r1, c = c1;
        
        // r 좌표 먼저 맞추기
        while (r !== r2) {
            r = r < r2 ? r + 1 : r - 1;
            path.push([r, c]);
        }
        
        // c 좌표 맞추기
        while (c !== c2) {
            c = c < c2 ? c + 1 : c - 1;
            path.push([r, c]);
        }
        
        return path;
    };
    
    // 각 로봇의 경로 추적
    routes.forEach((route) => {
        let time = 0;
        
        // 1. 로봇이 처음 시작하는 위치
        const start = route[0];
        const startPos = points[start - 1];
        const posKey = startPos.join(',');
        
        // 출발 위치 기록
        if (!robotPath.has(time)) {
            robotPath.set(time, new Map());
        }
        
        const cur = robotPath.get(time);
        cur.set(posKey, (cur.get(posKey) || 0) + 1);
        
        // 2. 로봇의 경로를 따라가며 기록
        for (let i = 0; i < route.length - 1; i++) {
            const start = route[i];
            const end = route[i + 1];
            
            const path = getPath(start, end);
            
            path.forEach(pos => {
                time++;
                const posKey = pos.join(',');
                
                // 해당 시간에 해당 좌표에 도착한 로봇 수 기록
                if (!robotPath.has(time)) {
                    robotPath.set(time, new Map());
                }
                
                const cur = robotPath.get(time);
                cur.set(posKey, (cur.get(posKey) || 0) + 1);
            });
        }
    });
    
    // 위험 상황 계산
    let answer = 0;
    
    robotPath.forEach((map) => {
        map.forEach((robotCount) => {
            if (robotCount > 1) {
                answer += 1; // 2대 이상이 모였을 때 위험 상황 추가
            }
        });
    });
    
    return answer;
}
