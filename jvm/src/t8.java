class C{

    static {
        System.out.println("Class c");
    }
}
public class t8 {

    public static void main(String[] args) throws Exception {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = systemLoader.loadClass("C");
        //此时只是加载，不是初始化类，只完成加载的阶段

        System.out.println("------------");
        clazz = Class.forName("C");
        //此时是对类的主动使用

    }
}
