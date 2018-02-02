public class t11 {

    public static void main(String[] args) {

        String str1 = "hello";

        String str2 = "hello";

        System.out.println(str1 == str2);
        //true，表示是一个对象

        String str3 = new String("hello");

        System.out.println(str1 == str3);
        //false

        String str4 = str3.intern();

        System.out.println(str1 == str4);
        //true
    }
}
