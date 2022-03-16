package mini_assignment_1;

public class Area {
    public static void main(String[] args) {
        int l = 7;
        int b = 8;
        double r = 4.0;
        int s = 4;
        int base = 6;
        int height = 7;
        // passing the values
        Area.Rectangle(l,b);
        Area.Square(s);
        Area.Circle(r);
        Area.Triangle(base,height);
    }
    public static int Rectangle(int l,int b){
        int area = l*b;
        System.out.println("Area of rectangle..."+area);
        return 0;
    }
    public static int Square(int s){
        int area = s*s;
        System.out.println("Area of square..."+area);
        return 0;
    }
    public static double Circle(double r){
        double area = 22*r*r/7;
        System.out.println("Area of circle..."+area);
        return 0;
    }
    public static int Triangle(int base,int height){
        int area = base*height/2;
        System.out.println("Area of triangle..."+area);
        return 0;
    }
}

