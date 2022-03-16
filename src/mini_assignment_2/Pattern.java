package mini_assignment_2;


import java.util.Scanner;



public class Pattern {

        public static void main(String[] args){

            Scanner sc = new Scanner(System.in);



            System.out.println("Enter the number of rows you want to print :");

            int rows = sc.nextInt();



            for(int i=1;i<=rows;i++){

                for(int j=1;j<=rows-i;j++){

                    System.out.print("");

                }

                for(int j=1;j<=i;j++){

                    System.out.print("*");

                }

                System.out.println();

            }

            for(int i=9;i>=1;i--){

                for(int j=1;j<=rows-i;j++){

                    System.out.print("");

                }

                for(int j=1;j<=i;j++){

                    System.out.print("*");

                }

                System.out.println();

            }

        }

    }

