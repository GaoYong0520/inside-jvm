public class t11 {

    public static void main(String[] args) {

        String str1 = "hello";

        String str2 = "hello";

        //true，表示是一个对象
        System.out.println(str1 == str2);


        String str3 = new String("hello");

        //false
        System.out.println(str1 == str3);


        String str4 = str3.intern();
        //true
        System.out.println(str1 == str4);

    }
}
