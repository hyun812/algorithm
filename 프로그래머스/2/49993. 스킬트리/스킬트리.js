function solution(skill, skill_trees) {
    let answer = 0;
    
    for (const skillTrees of skill_trees) {
        let check = true;
        let index = 0;
        for (let i = 0; i < skillTrees.length; i++) {
            if (!skill.includes(skillTrees[i])) continue;
            if (skill[index] !== skillTrees[i]) {
                check = false;
                break;
            }
            index++;
        }
        
        if (check) answer++;
    }
    
    return answer;
}