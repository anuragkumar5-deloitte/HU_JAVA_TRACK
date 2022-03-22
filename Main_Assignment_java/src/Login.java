import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    public static boolean handleLogin(String userName, String password) {
        boolean loginSuccess = false;
        BufferedReader reader = null;
        try{
            List<Credentials> credentials = new ArrayList<Credentials>();
            String line = "";
            reader = new BufferedReader(new FileReader("./Credentials.csv"));
//            reader.readLine();

            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    Credentials parseCredentials = new Credentials();
                    parseCredentials.setUserID(fields[0]);
                    parseCredentials.setPassword(fields[1]);
                    credentials.add(parseCredentials);
                }
            }

            for(Credentials c:credentials){
                if (c.getUserID().equals(userName) && c.getPassword().equals(password)){
                    loginSuccess = true;
                    break;
                }
            }

            return loginSuccess;

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return loginSuccess;
    }
    public static void login(){
        Scanner sc = new Scanner(System.in);
        String userName, password;
            System.out.println("\n****Welcome To Login Page****");
            System.out.print("User Name: ");
            userName = sc.next();
            System.out.print("Password :");
            password = sc.next();
            System.out.println("\n********************************\n");

        boolean loginSuccess = handleLogin(userName, password);
        if(loginSuccess){
            System.out.println("Successful Log In");
            UserDataBaseHome.userDBHome();
        }
        else {
            System.out.println("The user Name or Password you entered didn't match");
        }

    }
}
