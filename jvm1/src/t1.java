class Singleton{

    //位置1
    //private static Singleton singleton = new Singleton();
    //准备阶段null，初始化阶段指向实例
    public static int counter1;
    //准备阶段n0，singleton初始化时赋值1,初始化阶段不赋值，任为1

    public static int counter2 = 0;

    //准备阶段0,初始化实例时候为1,初始化counter2时候为0
    //两个不同的地方值不同
    //位置2
    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance(){
        return singleton;
    }
}


public class t1 {
    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1=" + singleton.counter1);
        System.out.println("counter2=" + singleton.counter2);

    }
}
