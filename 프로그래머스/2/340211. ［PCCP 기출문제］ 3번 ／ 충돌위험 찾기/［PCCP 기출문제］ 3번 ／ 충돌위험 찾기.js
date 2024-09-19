function solution(points, routes) {
    const n = points.length; // 포인트 개수
    const x = routes.length; // 로봇 개수
    
    // 모든 로봇의 이동 경로를 시뮬레이션하여 시간별 위치 기록
    const positionsByTime = new Map(); // 시간별 좌표 기록 { 시간: {좌표: 로봇 수} }
    
    const getPath = (start, end) => {
        const [r1, c1] = points[start - 1];
        const [r2, c2] = points[end - 1];
        
        const path = [];
        let r = r1, c = c1;
        
        // r 좌표 먼저 맞추기
        while (r !== r2) {
            if (r < r2) r++;
            else r--;
            path.push([r, c]);
        }
        
        // c 좌표 맞추기
        while (c !== c2) {
            if (c < c2) c++;
            else c--;
            path.push([r, c]);
        }
        
        return path;
    };
    
    // 각 로봇의 경로 추적
    routes.forEach((route, robotIndex) => {
        let time = 0;
        
        // 1. 로봇이 처음 시작하는 위치
        const start = route[0];
        const startPos = points[start - 1];
        const posKey = startPos.join(',');
        
        // 출발 위치 기록
        if (!positionsByTime.has(time)) {
            positionsByTime.set(time, new Map());
        }
        
        const currentMap = positionsByTime.get(time);
        currentMap.set(posKey, (currentMap.get(posKey) || 0) + 1);
        
        // 2. 로봇의 경로를 따라가며 기록
        for (let i = 0; i < route.length - 1; i++) {
            const start = route[i];
            const end = route[i + 1];
            
            const path = getPath(start, end);
            
            path.forEach(pos => {
                time++;
                const posKey = pos.join(',');
                
                // 해당 시간에 해당 좌표에 도착한 로봇 수 기록
                if (!positionsByTime.has(time)) {
                    positionsByTime.set(time, new Map());
                }
                
                const currentMap = positionsByTime.get(time);
                currentMap.set(posKey, (currentMap.get(posKey) || 0) + 1);
            });
        }
    });
    
    // 위험 상황 계산
    let dangerCount = 0;
    
    positionsByTime.forEach((map) => {
        map.forEach((robotCount) => {
            if (robotCount > 1) {
                dangerCount += 1; // 2대 이상이 모였을 때 위험 상황 추가
            }
        });
    });
    
    return dangerCount;
}
