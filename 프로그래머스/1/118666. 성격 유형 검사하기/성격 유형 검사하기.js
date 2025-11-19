function solution(survey, choices) {
    const personality = {'RT': [0, 0], "CF": [0, 0], "JM": [0, 0], "AN": [0, 0]}
    const n = survey.length;
    
    for (let i = 0; i < survey.length; i++) {
        if (choices[i] === 4) continue;
        
        if (personality[survey[i]]) {
            if (choices[i] < 4) {
                personality[survey[i]][0] += 4 - choices[i];
            } else {
                personality[survey[i]][1] += choices[i] - 4;
            }
        } else {
            const reverse = `${survey[i][1]}${survey[i][0]}`;
            if (choices[i] < 4) {
                personality[reverse][1] += 4 - choices[i];
            } else {
                personality[reverse][0] += choices[i] - 4;
            }
        }
    }
    
    let answer = '';
    for (const key in personality) {
        if (personality[key][0] >= personality[key][1]) {
            answer += key[0];
        } else {
            answer += key[1];
        }
    }
    
    return answer;
}