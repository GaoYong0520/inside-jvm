import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    private String name;//加载器名字

    private String path = "g:\\Code\\Java\\Practise\\jvm";//加载器的路径

    private final String fileType = ".class";//class文件扩展名

    public MyClassLoader(String name) {
        super();//让系统类加载器成为该类的父加载器
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name) {
        super(parent);//显式指定父加载器
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try{
            this.name = this.name.replace(".", "\\");
            is = new FileInputStream(new File(path + name + fileType));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        }
        catch (Exception e){

        }
        finally {
            try {
                is.close();
                baos.close();
            }
            catch (Exception e){

            }
        }
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 =new MyClassLoader("loader1");
        loader1.setPath("G:\\Code\\Java\\Practise\\jvm\\serverlib\\");
        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
        loader2.setPath("G:\\Code\\Java\\Practise\\jvm\\clientlib\\");
        MyClassLoader loader3 = new MyClassLoader(null, "loader3");//父加载器设置为根加载器
        loader3.setPath("G:\\Code\\Java\\Practise\\jvm\\otherlib\\");
        test(loader2);
        test(loader3);
    }

    public static void test(ClassLoader loader) throws Exception {
        Class clazz = loader.loadClass("Sample");

        Object obj = clazz.newInstance();
    }
}
