function solution(book_time) {
    const CLEANING_TIME = 10;
    
    const convertTimeToMinutes = (time) => {
        const [h, m] = time.split(':');
        return h * 60 + Number(m);
    }
    
    const newBook = book_time
            .map(([start, end]) => [convertTimeToMinutes(start), convertTimeToMinutes(end) + CLEANING_TIME])
            .sort((a, b) => a[0] - b[0]);
    
    const roomList = [];
    for (const [start, end] of newBook) {
        const emptyRoomIndex = roomList.findIndex((room) => room <= start);
    
        if (emptyRoomIndex === -1) {
            roomList.push(end);
        } else {
            roomList[emptyRoomIndex] = end;
        }
    }

    return roomList.length;

    
    return answer;
}