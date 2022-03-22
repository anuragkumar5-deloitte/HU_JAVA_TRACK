import java.util.Scanner;

public class UserDataBaseHome {

    static boolean handleUserDBChoice(int ch) {
        Scanner sc = new Scanner(System.in);
        switch (ch){
            case 1:
                System.out.print("Generated User Id :"+handleUserDb.getNextUserID("./UserDataBase.csv")+"\n");
                System.out.print("Name :");
                String name = sc.nextLine();
                System.out.print("Age :");
                int age = Integer.parseInt(sc.nextLine());
                System.out.print("Company name :");
                String companyName = sc.nextLine();
                System.out.print("Designation :");
                String designation = sc.nextLine();
                System.out.print("Salary :");
                double salary = Double.parseDouble(sc.nextLine());
                System.out.print("Address :");
                String address = sc.nextLine();
                System.out.print("Phone Number :");
                String phoneno = sc.nextLine();
                handleUserDb.addUser(name,age, companyName, designation, salary, address, phoneno);

                break;

            case 2:
                handleUserDb.displayUserData();
                break;
            case 3:
                handleUserDb.updateUserData();
                break;
            case 4:
                handleUserDb.deleteUserData();
                break;
            case 5:return(true);
            default:
                System.out.println("Please enter a valid choice");
        }
        return false;
    }
    public static void userDBHome(){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int ch = -1;
        do {
            System.out.println("\n****Welcome To User Database****");
            System.out.println("1. Add user data");
            System.out.println("2. List user data");
            System.out.println("3. Update user data");
            System.out.println("4. Delete user data");
            System.out.println("5. Exit");
            System.out.println("\n********************************\n");
            System.out.println("Enter your choice : ");
            ch = sc.nextInt();
            exit = handleUserDBChoice(ch);


        }while(!exit);

    }
}
