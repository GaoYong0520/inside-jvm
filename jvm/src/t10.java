import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class t10 {
//
//    public int test(ArrayList<Integer> t1) {
//        int a = 0;
//        return a;
//    }

    public int test(ArrayList<String> t1) {
        int a = 0;
        return a;
    }


    public static void test1(ArrayList<Object> a) {
        for( Object obj : a ) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        ArrayList<Integer> li = new ArrayList<Integer>();
        System.out.println(ls.getClass());
        System.out.println(ls.getClass() == li.getClass());
        //test1(li);
        //ls = new LinkedList<>();
    }
}
