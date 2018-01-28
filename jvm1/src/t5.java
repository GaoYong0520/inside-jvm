class Parent{

    static int a = 3;

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent{

    static int b = 4;

    static {
        System.out.println("Child static block");
    }
}

public class t5 {

    static {
        System.out.println("Main static block");
    }

    public static void main(String[] args) {
        //Child导致了父类的初始化
        System.out.println(Child.b);
    }
}
