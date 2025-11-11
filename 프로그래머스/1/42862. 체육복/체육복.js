function solution(n, lost, reserve) {
    let lost_student = lost.filter(v => !reserve.includes(v)).sort((a, b) => a - b);;
    let reserve_student = reserve.filter(v => !lost.includes(v)).sort((a, b) => a - b);;
    
    for (const num of reserve_student) {
        if (lost_student.includes(num - 1)) {
            lost_student = lost_student.filter((v) => v !== num - 1);
        } else if (lost_student.includes(num + 1)) {
            lost_student = lost_student.filter((v) => v !== num + 1);
        }
    }
    
    return n - lost_student.length;
}