import java.util.Random;

class FinalTest2{

    public static final int x = new Random().nextInt(100);

    static {
        System.out.println("Finaltest block");
    }
}

public class t4 {

    public static void main(String[] args) {
        System.out.println(FinalTest2.x);
    }
}
