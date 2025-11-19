function solution(survey, choices) {
    const personality = { 'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0};
    const n = survey.length;
    
    for (let i = 0; i < n; i++) {
        const score = 4 - choices[i]; // 양수면 첫번째, 음수면 두번째
        const type = score > 0 ? survey[i][0] : survey[i][1];
        personality[type] += Math.abs(score);
    }
    
    const { R, T, C, F, J, M, A, N } = personality;
    return `${R >= T ? 'R' : 'T'}${C >= F ? 'C' : 'F'}${J >= M ? 'J' : 'M'}${A >= N ? 'A' : 'N'}`
}