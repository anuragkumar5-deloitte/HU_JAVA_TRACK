public class Student implements Comparable<Student> {
    private String Name;
    private String Reg_No_10th;
    private String Reg_No_12th;
    private String Reg_No_BE;
    private int Rank;
    public void setName(String name) {
        this.Name = name;
    }
    public void setReg_No_10th(String Reg_No_10th) {
        this.Reg_No_10th= Reg_No_10th;
    }
    public void setReg_No_12th(String Reg_No_12th) {
        this.Reg_No_12th = Reg_No_12th;
    }
    public void setReg_No_BE(String Reg_No_BE) {
        this.Reg_No_BE = Reg_No_BE;
    }
    public void setRank(int Rank) {
        this.Rank = Rank;
    }
    public String getName() {
        return Name;
    }
    public String getReg10th() {
        return Reg_No_10th;
    }
    public String getReg12th() {
        return Reg_No_12th;
    }
    public String getRegBtech() {
        return Reg_No_BE;
    }
    public int getRank() {
        return Rank;
    }
    @Override
    public int compareTo(Student o) {
        //sort according to the rank in ascending order
        int compareRank = ((Student)o).getRank();
        return this.Rank - compareRank;
    }
}