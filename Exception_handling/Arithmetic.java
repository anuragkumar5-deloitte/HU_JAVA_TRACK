package Exception_handling;
import java.io.*;

public class Arithmetic {

        public static void main(String[] args)
        {
            try {
                System.out.println("inside try block");
                System.out.println(17 / 2);
            }

            catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception");

            }
            finally {
                System.out.println(
                        "finally : Thank you!");

            }
        }
    }

