function solution(user_id, banned_id) {
    let answer = 0;
    let visit = [];
    const set = new Set();
    
    const check = (a, b) => {
        for(let i=0; i<a.length; i++){
            if(a[i] === '*') continue;
            if(a[i] !== b[i]) return false;
        }
        return true;
    }
    
    const dfs = (idx, count, str) => {
        if(count === banned_id.length) {
            return;
        }
        
        for(let i=idx; i<banned_id.length; i++){
            for(let j=0; j<user_id.length; j++){
                if(visit[j]) continue;                
                if(banned_id[i].length !== user_id[j].length) continue;
                if(!check(banned_id[i],user_id[j])) continue;
                
                visit[j]=1;
                dfs(i+1, count+1, str+" "+user_id[j]);
                visit[j]=0;
            }
        }

    }
    
    dfs(0,0,"");
    
    const makeList=(idx_i,count,str)=>{
        if(count===banned_id.length){
            let arr=str.split(" ");
            arr.shift();
            arr.sort();
            let newstr=arr.join("");
            set.add(newstr);
        } 
        if(idx_i>=user_id.length) return;
        
        for(let i=idx_i;i<banned_id.length;i++){
            for(let j=0;j<user_id.length;j++){
                /**
                	중복체크
                **/
                if(visit[j]) continue;
                /**
                    조건일치하지 않는 경우 무시
                **/
                if(banned_id[i].length!==user_id[j].length) continue;
                if(!check(banned_id[i],user_id[j])) continue;
                /**
                	백트래킹
                **/
                visit[j]=1;
                makeList(i+1,count+1,str+" "+user_id[j]);
                visit[j]=0;
            }
        }
    }
    
    makeList(0,0,"");
    return set.size;
}