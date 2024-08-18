function solution(bandage, health, attacks) {
    var answer = 0;
    
    const [time, recoverySecond, addRecovery] = bandage;
    let max = health;
    let curTime = 0;
    let index = 0;
    let count = 0;
    while(index <= attacks.length-1){
        if(health <= 0) break;
        curTime++;
        
        if(curTime === attacks[index][0]) {
            health -= attacks[index][1];
            index++;
            count = 0;
        }else {
            health += recoverySecond;
            count++;
            
            if(count === time) {
                health += addRecovery;
                count = 0;
            };
            if(health > max) health = max;
        }
    }
    
    return health <= 0 ? -1 : health;
}