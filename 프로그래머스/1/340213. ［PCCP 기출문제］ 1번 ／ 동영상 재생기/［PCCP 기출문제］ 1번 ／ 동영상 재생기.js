/**
    video_len: 동영상의 길이
    pos: 기능이 수행되기 직전의 재생 위치
    op_start: 오프닝 시작 시간
    op_end: 오프닝 끝나는 시간
    commands: 사용자의 입력 배열
**/
function solution(video_len, pos, op_start, op_end, commands) {
    const len = convertTimeToMinutes(video_len);
    const m_pos = convertTimeToMinutes(pos);
    
    let cur = m_pos;
    cur = openingCheck(cur, convertTimeToMinutes(op_start), convertTimeToMinutes(op_end));
    
    commands.forEach(command => {
        cur = commandDoIt(command, cur, len);
        cur = openingCheck(cur, convertTimeToMinutes(op_start), convertTimeToMinutes(op_end));
    })
    
    return convertMinutesToTime(cur);
}

function convertTimeToMinutes(time) {
    const [hour, minutes] = time.split(':').map(Number);
    return hour * 60 + minutes;
}

function convertMinutesToTime(time) {
    let hour = (Math.floor(time / 60)).toString().padStart(2, "0");
    let minutes = (time % 60).toString().padStart(2, "0");
    
    return `${hour}:${minutes}`
}

function commandDoIt(command, time, len) {
    switch(command) {
        case "next":
            return time + 10 > len ? len : time + 10;
            break;
        case "prev":
            return time - 10 < 0 ? 0 : time - 10;
            break;
    }
}

function openingCheck(time, op_start, op_end) {
    if (time >= op_start && time <= op_end) {
        return op_end;
    }
    return time;
}