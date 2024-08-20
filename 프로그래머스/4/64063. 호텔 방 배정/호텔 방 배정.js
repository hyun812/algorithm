function solution(k, room_number) {
    var answer = [];
    
    const room = new Map();
    const find = (number) => {
        if(!room.has(number)){
            room.set(number, number+1);
            return number;
        }
        const findNumber = find(room.get(number));
        room.set(number, findNumber+1);
        return findNumber;
    }
    
    for(let i=0; i<room_number.length; i++){
        answer.push(find(room_number[i]));
    }
    
    return answer;
}