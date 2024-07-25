/*
    bridge_length: 다리에 올라갈 수 있는 트럭 수
    weight: 다리가 견딜 수 있는 무게
    truck_weights: 트럭 별 무게 배열
    
    트럭은 정해진 순서대로 건넌다
*/
function solution(bridge_length, weight, truck_weights) {
    let answer = 0;
    
    const bridge = new Array(bridge_length).fill(0);
    
    while(bridge.length){
        bridge.shift();
        
        if(truck_weights.length){
            const bridge_weight = bridge.reduce((acc, cur) => acc + cur, 0);
            if(bridge_weight + truck_weights[0] <= weight){
                bridge.push(truck_weights.shift());
            }else{
                bridge.push(0);
            }
        }
        answer++;
    }

    return answer;
}