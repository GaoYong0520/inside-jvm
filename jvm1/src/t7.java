class Parent3{
    static int a = 2;

    static {
        System.out.println("Parent block");
    }

    static void dosomething(){
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {

    //该块不会执行

    static {
        System.out.println("Child static block");
    }
}
public class t7 {

    public static void main(String[] args) {
        System.out.println(Child3.a);
        //a定义在parent中，不是在child中，没有导致child的初始化
        //dosomething()同样
        Child3.dosomething();

    }
}
