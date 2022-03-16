package mini_assignment_1;
public class Animal {

    private String king;
    private String apex_predator;
    private int doz;
    public static void main(String[] args) {
        Animal o = new Animal();
        o.King();
        o.apex_predator();
        o.Doz();
    }
    public void King(){
        king = "Lion";
        System.out.println("Private variable..."+king);
    }
    public void apex_predator(){
        apex_predator = "Dinosaur";
        System.out.println("Private variable..."+apex_predator);
    }
    public void Doz(){
        doz = 9;
        System.out.println("Private variable..."+doz);
    }
}


