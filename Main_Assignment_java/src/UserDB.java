import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class handleUserDb{

    static String userIdNext = "0";
    public static String getNextUserID(String filePath) {
        BufferedReader reader = null;
        String nextID = "0";
        try{
//            List<Credentials> credentials = new ArrayList<Credentials>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    nextID = fields[0];
                }
            }

            nextID = String.valueOf(Integer.parseInt(nextID)+1);

            return nextID;

        } catch (Exception e){
            userIdNext = "1";
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
//                System.out.println(e);
            }
        }
        userIdNext = "1";
        return userIdNext;
    }

    public static void addUser(String Name,int Age, String CompanyName, String Designation, double Salary, String Address, String Phoneno) {
        FileWriter fileWriter = null;
        String filePath = "./UserDataBase.csv";
        try {
            fileWriter = new FileWriter(filePath, true);

                userIdNext = getNextUserID("./UserDataBase.csv");
                if(userIdNext.equals("1")){
                    fileWriter.append("User Id, Name, Age, Company Name, Designation, Salary, Address, Phone Number\n");
                }
//                userName = userIdNext;
            fileWriter.append(userIdNext + "," + Name+ ","  + Age+ "," + CompanyName+ "," + Designation+ "," + Salary+ "," + Address+ "," + Phoneno + "\n");
            userIdNext= String.valueOf(Integer.parseInt(userIdNext)+1);

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

    public static void displayUserData() {
        BufferedReader reader = null;
        try{
            List<UserDB> userdb = new ArrayList<UserDB>();
            String line = "";
            reader = new BufferedReader(new FileReader("./UserDataBase.csv"));
            reader.readLine();

            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    UserDB parseUserDetails = new UserDB();
                    parseUserDetails.setUserID(fields[0]);
                    parseUserDetails.setName(fields[1]);
                    parseUserDetails.setAge(Integer.parseInt(fields[2]));
                    parseUserDetails.setCompanyName(fields[3]);
                    parseUserDetails.setDesignation(fields[4]);
                    parseUserDetails.setSalary(Double.parseDouble(fields[5]));
                    parseUserDetails.setAddress(fields[6]);
                    parseUserDetails.setPhoneNumber(fields[7]);
                    userdb.add(parseUserDetails);
                }
            }

            System.out.println("_______________________________________________________________________________________________________________________________________________________");
            System.out.println("|  User ID  |          Name          |  Age  |      Company Name      |     Designation      |    Salary    |        Address       |   Phone Number  |");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

            for(UserDB d: userdb){
                System.out.printf("   %-12s   %-20s %4d      %-23s  %-21s %10.2f    %-22s  %-16s",d.getUserID(),d.getName(),d.getAge(),d.getCompanyName(),d.getDesignation(),d.getSalary(),d.getAddress(),d.getPhoneNumber());
                System.out.println();
            }

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void writeToFile(List<UserDB> userdb){
        FileWriter fileWriter = null;
        String filePath = "./UserDataBase.csv";
        try {
            fileWriter = new FileWriter(filePath, false);

            fileWriter.append("User Id, Name, Age, Company Name, Designation, Salary, Address, Phone Number\n");
            for(UserDB d: userdb){
                fileWriter.append( d.getUserID()+ "," +d.getName()+ ","  + d.getAge()+ "," + d.getCompanyName()+ "," + d.getDesignation()+ "," + d.getSalary()+ "," + d.getAddress()+ "," + d.getPhoneNumber() + "\n");
            }

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
    public static void updateUserData(){
        BufferedReader reader = null;
        try{
            List<UserDB> userdb = new ArrayList<UserDB>();
            String line = "";
            reader = new BufferedReader(new FileReader("./UserDataBase.csv"));
            reader.readLine();

            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    UserDB parseUserDetails = new UserDB();
                    parseUserDetails.setUserID(fields[0]);
                    parseUserDetails.setName(fields[1]);
                    parseUserDetails.setAge(Integer.parseInt(fields[2]));
                    parseUserDetails.setCompanyName(fields[3]);
                    parseUserDetails.setDesignation(fields[4]);
                    parseUserDetails.setSalary(Double.parseDouble(fields[5]));
                    parseUserDetails.setAddress(fields[6]);
                    parseUserDetails.setPhoneNumber(fields[7]);
                    userdb.add(parseUserDetails);
                }
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the User Id :");
            String userId = sc.nextLine();
            for(UserDB d: userdb){
                if(d.getUserID().equals(userId)){
                    System.out.print("Update Name :");
                    d.setName(sc.nextLine());
                    System.out.print("Update Age :");
                    d.setAge(Integer.parseInt(sc.nextLine()));
                    System.out.print("Update Company name :");
                    d.setCompanyName(sc.nextLine());
                    System.out.print("update Designation :");
                    d.setDesignation(sc.nextLine());
                    System.out.print("Update Salary :");
                    d.setSalary(Double.parseDouble(sc.nextLine()));
                    System.out.print("Update Address :");
                    d.setAddress(sc.nextLine());
                    System.out.print("Update Phone Number :");
                    d.setPhoneNumber(sc.nextLine());
                }
            }

            writeToFile(userdb);

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void deleteUserData(){
        BufferedReader reader = null;
        try{
            List<UserDB> userdb = new ArrayList<UserDB>();
            String line = "";
            reader = new BufferedReader(new FileReader("./UserDataBase.csv"));
            reader.readLine();

            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    UserDB parseUserDetails = new UserDB();
                    parseUserDetails.setUserID(fields[0]);
                    parseUserDetails.setName(fields[1]);
                    parseUserDetails.setAge(Integer.parseInt(fields[2]));
                    parseUserDetails.setCompanyName(fields[3]);
                    parseUserDetails.setDesignation(fields[4]);
                    parseUserDetails.setSalary(Double.parseDouble(fields[5]));
                    parseUserDetails.setAddress(fields[6]);
                    parseUserDetails.setPhoneNumber(fields[7]);
                    userdb.add(parseUserDetails);
                }
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the User Id :");
            String userId = sc.nextLine();
            userdb.removeIf(d -> d.getUserID().equals(userId));
            writeToFile(userdb);

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }
}
public class UserDB {

    private String userID;
    private String name;
    private int age;
    private String companyName;
    private String designation;
    private double salary;
    private String address;
    private String phoneNumber;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
