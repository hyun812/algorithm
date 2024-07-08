/*
    enroll: 각 판매원의 이름을 담은 배열
    referral: 각 판매원을 조직에 참여시킨 다른 판매원의 이름을 담은 배열
    seller: 판매량 집계 데이터의 판매원 이름을 나열한 배열
    amount: 판매량 집계 데이터의 판매 수량을 나열한 배열
    
    return: 각 판매원의 이익금을 나열한 배열
*/
function solution(enroll, referral, seller, amount) {
    const members = new Map();
    enroll.forEach((member, i) => {
        members.set(member, { referral: referral[i], profit: 0});
    })
    
    for(let i=0; i<seller.length; i++){
        let money = amount[i] * 100;
        let member = members.get(seller[i]);
        
        while(money && member){
            const dis = Math.floor(money/10);
            
            member.profit += money - dis;
            money = dis;
            member = members.get(member.referral);
        }
    }
    
    return enroll.map((member)=> members.get(member).profit);
}