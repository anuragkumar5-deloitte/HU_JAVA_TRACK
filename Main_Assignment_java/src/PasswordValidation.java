import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HandleInvalidPassword extends Exception {
    int conditionCode = 0;

    public HandleInvalidPassword(int code){
        super("You entered an Invalid password :");
        conditionCode = code;
    }

    public String warningMessage(){
        switch (conditionCode){
            case 1: return ("Password should be 5 to 10 characters long");
            case 2: return ("Password should contain at least one Uppercase Alphabet (A-Z)");
            case 3: return ("Password should contain at least one Lowercase Alphabet (a-z)");
            case 4: return ("Password should contain at least one special character\"@ # & % * !\"");
            case 5: return ("Password should contain at least one digit (0-9)");
            default: return ("");
        }
    }

}
class ValidatePassword{

    public static void isPasswordValid(String password) throws HandleInvalidPassword {
        if (!((password.length() >= 5) && (password.length() <= 10))){
            throw new HandleInvalidPassword(1);
        }

        if (true){
            int countUpper = 0;
            int countLower = 0;
            int countDigit = 0;

//Uppercase criteria for password
            for (int i = 65; i <= 90; i++) {

                char c = (char)i;

                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    countUpper = 1;
                }
            }

//Lowercase criteria for password
            for (int i = 90; i <= 122; i++) {

                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);

                if (password.contains(str1)) {
                    countLower = 1;
                }
            }

//Special case criteria for password
            if (!(password.contains("@") || password.contains("#")
                    || password.contains("&") || password.contains("%")
                    || password.contains("*") || password.contains("!"))) {
                throw new HandleInvalidPassword(4);
            }

//Digit criteria for password
            for (int i = 0; i <= 9; i++) {

                // to convert int to string
                String str1 = Integer.toString(i);

                if (password.contains(str1)) {
                    countDigit = 1;
                }
            }


            if (countDigit == 0) { throw new HandleInvalidPassword(5); }
            if (countLower == 0) { throw new HandleInvalidPassword(3); }
            if (countUpper == 0) { throw new HandleInvalidPassword(2); }

        }

    }
}
public class PasswordValidation {
    static String userIdNext = "0";
    public static void writeCsvCredentials(String filePath, String userName, String password) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);

//                userIdNext = getNextUserID("./Credentials.csv");
////            System.out.println("header init"+userIdNext+ userIdNext.getClass().getSimpleName());
//                if(userIdNext.equals("1")){
//
//                    fileWriter.append("userName, password\n");
//                }
//                userName = userIdNext;
                fileWriter.append(userName + "," + password + "\n");
//                userIdNext= String.valueOf(Integer.parseInt(userIdNext)+1);

        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch ( Exception e){
                System.out.println(e);
            }
        }

    }
//    public static String getNextUserID(String filePath) {
//        BufferedReader reader = null;
//        String nextID = "0";
//        try{
////            List<Credentials> credentials = new ArrayList<Credentials>();
//            String line = "";
//            reader = new BufferedReader(new FileReader(filePath));
//            reader.readLine();
//
//            while((line = reader.readLine()) != null){
//                String[] fields = line.split(",");
//
//                if(fields.length > 0) {
//                    nextID = fields[0];
//                }
//            }
//
//            nextID = String.valueOf(Integer.parseInt(nextID)+1);
//
//            return nextID;
//
//        } catch (Exception e){
//            userIdNext = "1";
//        } finally {
//            try {
//                reader.close();
//            } catch (Exception e) {
////                System.out.println(e);
//            }
//        }
//        userIdNext = "1";
//        return userIdNext;
//    }
    public static void StoreCredentials(){

        Scanner sc = new Scanner(System.in);
        ValidatePassword v = new ValidatePassword();


        try{
            System.out.println("Enter a User name : ");
            String userName = sc.next();

            System.out.println("Enter a password : ");
            String passwd1 = sc.next();

            System.out.println("Re-Enter a password : ");
            String passwd2 = sc.next();

            if(passwd1.equals(passwd2)){
            ValidatePassword.isPasswordValid(passwd1);
            String path = "./Credentials.csv";
            writeCsvCredentials(path, userName, passwd1);
            System.out.println("Your Registration was successful");
            }
            else{
                System.out.println("Registration Unsuccessful");
                System.out.println("The Password didn't match or you might have entered an Invalid password");
                System.out.println("A password must contain at least one of [A-Z], [a-z], [0-9], [@, #,  &,  %, *, ! ]");
            }
        }
        catch (HandleInvalidPassword e){
            System.out.println(e.getMessage());
            System.out.println(e.warningMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
