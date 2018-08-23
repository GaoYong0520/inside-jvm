public class Dog {
    public Dog() {
        System.out.println("dog is loaded by:" + this.getClass().getClassLoader());
    }
}
