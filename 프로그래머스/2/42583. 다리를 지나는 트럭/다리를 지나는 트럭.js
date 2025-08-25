function solution(bridge_length, weight, truck_weights) {
    let time = 0;
    const bridge = Array(bridge_length).fill(0);
    let cur = 0;
    
    while (truck_weights.length > 0 || cur > 0) {
        time++;
        cur -= bridge.shift();
        if (truck_weights.length > 0) {
            if (cur + truck_weights[0] <= weight) {
                const pop = truck_weights.shift();
                cur += pop;
                bridge.push(pop);                
            } else {
                bridge.push(0);
            }
        }
    }
    
    return time;
}