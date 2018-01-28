public class Sample {
    public Sample(){

        System.out.println("sample loaded by" + this.getClass().getClassLoader());
        Dog d = new Dog();
    }
}
