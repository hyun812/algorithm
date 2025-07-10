function solution(phone_book) {
    phone_book.sort((a, b) => a.length - b.length);
    
    const phone_len = [...new Set(phone_book.map((number) => number.length))];
    const map = new Map();
    
    for (const number of phone_book) {
        map.set(number);
        for (const len of phone_len) {
            if (len >= number.length) break;
            const prefix = number.slice(0, len);
            
            if (map.has(prefix)) {
                return false;
            }
        }
    }
    
    return true;
}