const convertTimeToMinutes = (time) => {
    const [h, m] = time.split(':');
    return h * 60 + m * 1;
}

function solution(m, musicinfos) {
    const answer = [];
    
    m = m.replaceAll("C#", "Z")
            .replaceAll("D#", "Y")
            .replaceAll("F#", "X")
            .replaceAll("G#", "W")
            .replaceAll("A#", "V")
            .replaceAll("B#", "U");
    
    for (const musicInfo of musicinfos) {
        const [startTime, endTime, title, info] = musicInfo.split(',');
        const diff = convertTimeToMinutes(endTime) - convertTimeToMinutes(startTime);
        const convertInfo = info.replaceAll("C#", "Z")
                                .replaceAll("D#", "Y")
                                .replaceAll("F#", "X")
                                .replaceAll("G#", "W")
                                .replaceAll("A#", "V")
                                .replaceAll("B#", "U");
        
        const newInfo = convertInfo.repeat(Math.ceil(diff / convertInfo.length)).slice(0, diff);
        if (newInfo.includes(m)) answer.push([title, diff]);
    }
    
    if (!answer.length) return "(None)";
    
    answer.sort((a, b) => {
        if (a[1] === b[1]) return 0;
        return b[1] - a[1];
    })
    
    return answer[0][0];
}