import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] game=new int[19][19];
    public static void main(String[] args) throws Exception {
        //////////////////////////////////////////////////////////////
        // 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
        //////////////////////////////////////////////////////////////
        //System.setIn(new FileInputStream("Test5.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0;i<19;i++)
        {
            String[] tmp=br.readLine().split(" ");
            for(int j=0;j<19;j++)
            {                
                game[i][j]=Integer.parseInt(tmp[j]);
            }
        }

        
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++)
            {
                if(game[i][j]!=0)
                {
                    if(checkWin(i,j,game[i][j]))
                    {
                        return;
                    }
                }
            }
        }
        System.out.println(0);
        
        
    }
    static boolean checkWin(int y,int x,int team)
    {
//        int[] dx= {0,1,1,1,0,-1,-1,-1};
//        int[] dy= {-1,-1,0,1,1,1,0,-1};
        int[] dx= {1,1,1,0};
        int[] dy= {-1,0,1,1};
        for(int i=0;i<4;i++)
        {
            int cnt=1;
            int tx=x+dx[i];
            int ty=y+dy[i];
            
            //이전에 쟀던 라인 체크하여 제외
            int bx=x-dx[i];
            int by=y-dy[i];
            if(bx>=0&&by>=0&&bx<19&&by<19&&game[by][bx]==team)
            {
                continue;
            }
            
            while(cnt<7)
            {
                if(tx>=0&&ty>=0&&tx<19&&ty<19&&game[ty][tx]==team)
                {
                    cnt++;
                }
                else
                    break;
                tx+=dx[i];
                ty+=dy[i];
            }
            //System.out.println(y+" "+x+" "+cnt+" "+team);
            if(cnt==5)
            {
                if(team==1)
                {
                    System.out.println(1);
                }
                else if(team==2)
                {
                    System.out.println(2);
                }
                System.out.println((y+1)+" "+(x+1));
                return true;
            }
        }
        return false;
    }
}