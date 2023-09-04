import java.util.*;
import java.io.*;

public class Main {
    static int n, m, dis;
    static int[][] map, clone;
    static int[] apos;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dis = Integer.parseInt(st.nextToken());

        map = new int[n][m]; // 적의 정보를 저장할 배열
        apos = new int[3]; // 궁수의 정보를 저장할 배열 (조합을 통해 궁수 위치 선택)
        ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        com(0, 0);

        System.out.println(ans);
    }

    private static void com(int cnt, int start){ // 조합
        if(cnt == 3){ // 궁수를 3명 다 뽑았으면
            clone = new int[n][m]; // 배열을 바꿔주기 위해 clone

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    clone[i][j] = map[i][j];
                }
            }
            attack(); // 공격
            return;
        }

        for(int i=start; i<m; i++){
            apos[cnt] = i;
            com(cnt+1, i+1);
        }
    }
    private static void attack(){
        int cnt =0; // 제거한 적의 갯수를 셀 변수
        for(int t=1; t<=n; t++){ // 게임 진행 횟수 n만큼
            boolean[][] visited = new boolean[n][m]; // 방문체크 배열
            for(int k=0; k<3; k++){ // 궁수 1명씩 체크
                int x = apos[k]; // 궁수의 x좌표
                int minD = Integer.MAX_VALUE; // 최소 거리
                int minY = Integer.MAX_VALUE; // 최소거리에 있는 적의 y좌표
                int minX = Integer.MAX_VALUE; // 최소거리의 있는 적의 x좌표

                for(int i=0; i<n; i++){ // 배열돌면서
                    for(int j=0; j<m; j++){
                        if(clone[i][j] == 1){ // 적이 있으면
                          if(minD > distance(i,j,n,x)){ // 최소 거리 보다 작으면 ( 궁수 <> 적 )
                            minD = distance(i,j,n,x); // 최소거리 초기화
                            minY = i; // y좌표
                            minX = j; // x좌표
                          }else if(minD == distance(i,j,n,x)){ // 최소 거리와 같다면 ( 궁수 <> 적)
                            if(minX > j){ // 거리가 같으면 가장 왼쪽에 있는 적을 공격해야 하므로 minX보다 현재 적의 x좌표가 더 작다면
                              minY = i; // 초기화
                              minX = j;
                            }
                          }
                        }
                    }
                }
                
                if(minD <= dis){ // 최소거리에 있는 적이 공격할 수 있는 사거리보다 작거나 같다면
                    visited[minY][minX] = true; // 방문처리
                    // 궁수 3명이 같은 적을 공격할 수 있으므로
                    // 방문체크를 해두고 추후에 제거
                }
            }

            // 궁수 3명 모두 체크했으면 visited배열에 true인 원소들을 제거 (0으로)
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(visited[i][j]){
                        clone[i][j] = 0;
                        cnt++;
                    }
                }
            }

            // 배열 하나씩 내리기
            // y좌표가 n-2인 배열 > n-1인 배열로 ...
            for(int i=n-2; i>=0; i--){
                for(int j=0; j<m; j++){
                    clone[i+1][j] = clone[i][j];
                }
            }
            for(int i=0; i<m; i++){
                clone[0][i] = 0;
            }
        }
        ans = Math.max(ans, cnt); // 적을 잡을 수 있는 최대값
    }
    
    private static int distance(int y1, int x1, int y2, int x2){ // 거리를 구하는 함수
        return Math.abs(y2-y1)+Math.abs(x2-x1);
    }
}

