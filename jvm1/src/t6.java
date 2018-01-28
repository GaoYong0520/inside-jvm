class Parent2{
    static int a = 2;

    static {
        System.out.println("Parent block");
    }
}

class Child2 extends Parent2 {
    static int b = 3;

    static {
        System.out.println("Child2 static block");
    }
}
public class t6 {

    static {
        System.out.println("Main static block");
    }

    public static void main(String[] args) {
        Parent2 p;//没有初始化类的实例，不是主动使用，不导致类的初始化

        System.out.println("-----------");
        p = new Parent2();

        System.out.println(Parent2.a);
        System.out.println(Child2.b);
    }
}
