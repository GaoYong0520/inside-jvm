class FinalTest{

    public static final int x = 6/3;

    static {
        System.out.println("final test block");
    }
}

public class t3 {

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
