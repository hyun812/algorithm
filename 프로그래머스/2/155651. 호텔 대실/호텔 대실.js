const convertTime = (time) => {
    const [h, m] = time.split(":").map(Number);
    
    return h*60 + m;
}

function solution(book_time) {
    const room = [];
    
    book_time.sort();
    
    book_time.forEach((time)=>{
        const [s, e] = time;
        
        const start = convertTime(s);
        const end = convertTime(e) + 10;
            
        const idx = room.findIndex((v) => v<=start);
        
        if(idx === -1) room.push(end);
        else room[idx] = end;
    })
    
    return room.length;
}