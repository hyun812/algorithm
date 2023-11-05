import java.io.*;
import java.util.*;

public class Solution {
    static int n, max, totalCnt, min;
    static int[][] arr;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());

        for(int tc=1; tc<=t; tc++){
            n = Integer.parseInt(bf.readLine());
            arr = new int[n][n];
            list = new ArrayList<>();
            max = 0;
            min = Integer.MAX_VALUE;
            totalCnt = 0; // 연결해야하는 코어 개수


            for(int i=0; i<n; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1){
                        if(i == 0 || i == n-1 || j == 0 || j == n-1) continue;
                        list.add(new int[] {i, j});
                        totalCnt++;
                    }
                }
            }

            powerSet(0, 0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
    // 부분집합 코어를 선택(4방향 시도)/비선택
    private static void powerSet(int start, int corent){ // start : 코어의 인덱스 , coreCnt : 연결된 코어 갯수
        // 가지치기 : 현재까지 연결된 코어수 + 남은 코어수 < 임시 최대 코어 연결수
        if(corent + (totalCnt-start) < max) return;
        
        // 기저조건 처리
        if(start == totalCnt){
            int res=  getLength(); // 놓아진 전선 길이의 합
            if(max < corent){
                max = corent;
                min = res;
            }else if (max == corent){
                if(min > res){
                    min = res;
                }
            }
            return;
        }

        // 현재 코어 선택 ( 4방향 시도)
        for(int i=0; i<4; i++){
            // 현재 코어의 위치에서 해당 방향으로 전선 놓기가 가능한지 체크
            if(!check(list.get(start), i)) continue;

            fill(list.get(start), i, 2); // 가능하다면 전선 놓기
            powerSet(start+1, corent+1); // 다음 코어로 가기
            fill(list.get(start), i, 0); // 새로운 방향을 시도하기 위해 놓았던 전선 지우기
        }

        powerSet(start+1, corent);
    }

    private static boolean check(int[] target, int dir){ // 4방향 중 갈 수 있는 방향인지 boolean
        int ny = target[0] + dy[dir];
        int nx = target[1] + dx[dir];

        while (outOfIdx(ny, nx)){
            if(arr[ny][nx] != 0) return false;

            ny += dy[dir];
            nx += dx[dir];
        }

        return true;
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};


    private static void fill(int[] target, int dir, int value){
        int ny = target[0] + dy[dir];
        int nx = target[1] + dx[dir];

        while (outOfIdx(ny, nx)){
            arr[ny][nx] = value;
            ny += dy[dir];
            nx += dx[dir];
        }
    }

    private static int getLength(){
        int lCnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 2){
                    lCnt++;
                }
            }
        }
        return lCnt;
    }

    private static boolean outOfIdx(int y, int x){
        if(y>=0 && y<n && x>=0 && x<n){
            return true;
        }
        return false;
    }
}