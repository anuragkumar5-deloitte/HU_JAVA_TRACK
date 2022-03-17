package Practice3;
import java.util.Scanner;

public class CSA {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt(); //Taking size of an array
            int[] arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = in.nextInt(); // Taking content of the array.
            }
            // Counting number of sub arrays whose summation is negative.
            int sum=0,count=0;
            for(int i=1,k,j;i<=N;i++){
                for(k=1;k<=N-i+1;k++){
                    for(j=0;j<i;j++){
                        sum += arr[j+k-1];
                    }
                    if(sum<0)
                        count++;
                    sum = 0;
                }
            }
            System.out.print(count);
            in.close();
        }
    }

