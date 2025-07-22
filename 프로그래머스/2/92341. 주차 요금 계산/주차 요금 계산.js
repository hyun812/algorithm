function solution(fees, records) {
   
    const convertTime = (time) => {
        const [hours, minutes] = time.split(":").map(Number);
        return hours * 60 + minutes;
    }
    
    const calcFees = (time) => {
        return time <= fees[0] ? fees[1] : fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3];
    }
    
    const answer = new Map();
    const map = new Map();
    for (let i = 0; i < records.length; i++) {
        const [time, num, type] = records[i].split(' ');

        if (type === "IN") {
            map.set(num, convertTime(time));
        }else if (type === "OUT") {
            const result = convertTime(time) - map.get(num);
            answer.set(num, (answer.get(num) || 0) + result);
            map.delete(num);
        }
    }
    
    if (map.size) {
        for (const [num, time] of map) {
            const result = convertTime("23:59") - time;
            console.log(result)
            answer.set(num, (answer.get(num) || 0) + result);
        }
    }
    
    const sortedMap = new Map([...answer.entries()].sort((a, b) => a[0] - b[0]));
    
    const results = [];
    for (const [num, time] of sortedMap) {
        results.push(calcFees(time));
    }
    return results;
}