
//레벨2 - 이진 변환 반복하기
public class binarytrans {
    public static void main(String[] args) {
        String s = "110010101001";
        
        int zero = 0;
        int count = 0;

        while(!s.equals("1")){
            int s_len = s.length();
            s = s.replace("0", "");
            zero += s_len-s.length();
            s = Integer.toBinaryString(s.length());
            count++;
        }

        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = zero;
    }
}
