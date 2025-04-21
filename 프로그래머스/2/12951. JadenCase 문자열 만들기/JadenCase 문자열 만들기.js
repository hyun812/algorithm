function solution(s) {
    return s.split(' ').map((v) => {
        if (!v.trim().length) return;
        
        const [first, ...word] = v.split('');
        return first.toUpperCase() + word.join('').toLowerCase();
    }).join(' ');
}