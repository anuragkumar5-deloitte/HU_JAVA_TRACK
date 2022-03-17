package Practice3;
import java.lang.*;

public class Shuffle {

        static boolean isInterleaved(String A, String B, String C)
        {


            int M = A.length(), N = B.length();
            boolean IL[][] = new boolean[M + 1][N + 1];
            // IL is default initialised by false
            // C can be an interleaving of A and B
            // only if the sum of lengths of A and B
            // is equal to length of C
            if ((M + N) != C.length())
                return false;
            // Process all characters of A and B
            for(int i = 0; i <= M; i++)
            {
                for(int j = 0; j <= N; j++)
                {


                    if (i == 0 && j == 0)
                        IL[i][j] = true;
                        // A is empty
                    else if (i == 0)
                    {
                        if (B.charAt(j - 1) == C.charAt(j - 1))
                            IL[i][j] = IL[i][j - 1];
                    }

                    else if (j == 0)
                    {
                        if (A.charAt(i - 1) ==  C.charAt(i - 1))
                            IL[i][j] = IL[i - 1][j];
                    }

                    else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1))
                        IL[i][j] = IL[i - 1][j];
                    else if (A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1))
                        IL[i][j] = IL[i][j - 1];
                    else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1))
                        IL[i][j] = (IL[i - 1][j] ||
                                IL[i][j - 1]);
                }
            }
            return IL[M][N];
        }

        // Function to run test cases
        static void checkInterleaving(String A, String B, String C)
        {
            if (isInterleaved(A, B, C))
                System.out.println("Valid shuffle");
            else
                System.out.println("Invalid shuffle");
        }

        // Driver code
        public static void main(String[] args)
        {
            checkInterleaving("gid", "Hash", "Hgasidh");
            checkInterleaving("gid", "Hash", "Hgsaidh");
        }
    }

