function solution(friends, gifts) {
    const map = new Map();
    friends.forEach((friend) => map.set(friend, 0));
    gifts.forEach((gift) => {
        const [from, to] = gift.split(" ");
        
        map.set(from, map.get(from) + 1);
        map.set(to, map.get(to) - 1);
    })
    
    const gift = new Array(friends.length).fill(0);
    for(let i=0; i<friends.length -1; i++){
        for(let j=i; j<friends.length; j++){
            const [from, to] = [friends[i], friends[j]];
        
            const give = gifts.filter((v) => v === `${from} ${to}`).length;
            const receive = gifts.filter((v) => v === `${to} ${from}`).length;

            if(give > receive) {
                gift[i]++;
            }else if(give < receive) {
                gift[j]++;
            }else if(give === receive) {
                if(map.get(from) > map.get(to)) {
                    gift[i]++;
                }else if(map.get(from) < map.get(to)) {
                    gift[j]++;
                }
            }    
        }
    }
        
    return Math.max(...gift);
}