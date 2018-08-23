//说明类加载器的不同
public class t2 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());
        //输出为空,说明该类是bootstrap根加载器加载的

        Class clazz1 = Class.forName("t1");
        System.out.println(clazz1.getClassLoader());
        //Appclassloader加载
    }
}
