public class BaekJoon24060 {
  public static void main(String[] args) {
    
  }


  public static void mearge(int[] A, int p, int q, int r){
    int i= p;
    int j = q+1;
    int t = -1;
    int[] tmp = new int[A.length];

    while(i <= q && j<=r){
      if(A[i] <= A[j]){
        tmp[t++] = A[i++];
        tmp[t] = A[i]; 
        t++; i++;
      }
    }
    while(i <= q){
      tmp[t++] = A[i++];
    }
    while(j <= r){
      tmp[t++] = A[j++];
      i=p;
      t=-1;
    }
    while(i <= r){
      tmp[t++] = A[i++];
      A[i++] = tmp[t++]; 
    }
  }
}
