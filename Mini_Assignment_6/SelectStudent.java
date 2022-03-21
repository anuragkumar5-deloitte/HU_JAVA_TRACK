import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class CsvReadWrite{
    public static void writeCsv(String filePath, List<Student> studentDataList){
//        List<StudentData> studentData = new ArrayList<StudentData>();
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(filePath);
            fileWriter.append("Name, Registration Number : 10th, Registration Number : 12th, Registration Number : B. Tech, Rank\n");
            Collections.sort(studentDataList);
            int count = 1;
            for (Student s: studentDataList){
                fileWriter.append(s.getName());
                fileWriter.append(",");
                fileWriter.append(s.getReg10th());
                fileWriter.append(",");
                fileWriter.append(s.getReg12th());
                fileWriter.append(",");
                fileWriter.append(s.getRegBtech());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(s.getRank()));
                fileWriter.append("\n");

                if(count == 5){
                    break;
                }
                count++;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch ( Exception e){
                System.out.println(e);
            }
        }
    }
    public static List<Student> readCsv(String filePath){
        BufferedReader reader = null;
        try{
            List<Student> studentData = new ArrayList<Student>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                if(fields.length > 0) {
                    Student parseStudentData = new Student();
                    parseStudentData.setName(fields[0]);
                    parseStudentData.setReg_No_10th(fields[1]);
                    parseStudentData.setReg_No_12th(fields[2]);
                    parseStudentData.setReg_No_BE(fields[3]);
                    parseStudentData.setRank(Integer.parseInt(fields[4]));
                    studentData.add(parseStudentData);
                }
            }
            return studentData;
        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }
}
public class SelectStudent {
    public static void main(String[] Args){
        List<Student> list = new ArrayList<Student>();
        String readFile = "C:\\Users\\anuragkumar5\\IdeaProjects\\Exception_handling_assigment\\src\\Student.csv";
        String writeFile = "C:\\Users\\anuragkumar5\\IdeaProjects\\Exception_handling_assigment\\src\\SelectedStudent.csv";
        list = CsvReadWrite.readCsv(readFile);
        CsvReadWrite.writeCsv(writeFile, list);
    }
}
