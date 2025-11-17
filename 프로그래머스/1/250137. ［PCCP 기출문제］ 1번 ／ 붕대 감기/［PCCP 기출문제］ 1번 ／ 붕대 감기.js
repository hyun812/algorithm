/**
    t초 동안 1초마다 x 체력 회복
    t초 연속 붕대 성공 시 추가 y
    
    bandage: [t, x, y]
    health: 최대 체력
    attacks: [공격 시간, 피해량]
    
    return: 남은 체력
**/
function solution(bandage, health, attacks) {
    const [t, x, y] = bandage;
    
    let cur = health;
    let time = 0;
    
    for (const [attackTime, damage] of attacks) {
        // 체력 회복 계산
        const diff = attackTime - time - 1;
        const success = Math.floor(diff / t);
        const recovery = diff * x + success * y;
        cur += recovery;
        if (cur >= health) cur = health;        
        
        cur -= damage;
        if (cur <= 0) return -1;
        time = attackTime;
    }
    
    return cur;
}