function solution(fees, records) {
   
    const convertTime = (time) => {
        const [hours, minutes] = time.split(":").map(Number);
        return hours * 60 + minutes;
    }
    
    const calcFees = (time) => {
        return time <= fees[0] ? fees[1] : fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3];
    }
    
    const map = new Map();
    for (let i = 0; i < records.length; i++) {
        let [time, num, type] = records[i].split(' ');
        time = convertTime(time);
        
        if (type === "IN") {
            map.set(num, (map.get(num) || 0) + 1439 - time);
        }else if (type === "OUT") {
            map.set(num, (map.get(num) || 0) - 1439 + time)
        }
    }
    
    const answer = [];
    for (const [key, value] of map) {
        answer.push([key, calcFees(value)]);
    }
    
    return answer.sort((a, b) => a[0] - b[0]).map(v => v[1]);
}