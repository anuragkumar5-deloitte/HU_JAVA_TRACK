import java.util.Scanner;

public class DatabaseHome {
    static boolean handleHomeChoice(int ch) {
        switch (ch){
            case 1:Login.login();
                break;
            case 2: PasswordValidation.StoreCredentials();
                break;
            case 3:return(true);
            default:
                System.out.println("Please enter a valid choice");
        }
        return false;
    }
    public static void home(){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int ch = -1;
        do {
            System.out.println("\n****Welcome To User Database****");
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("\n********************************\n");
            System.out.println("Enter your choice : ");
            ch = sc.nextInt();
            exit = handleHomeChoice(ch);


        }while(!exit);

    }
}
