public class t12 {

    public static volatile int race = 0;

    //加入sychronized方法可以保证正确性
    public static void increase() {
        race ++;
    }

    public static void main(String[] args) {

        Thread[] t = new Thread[20];

        for(int i=0;i<20;i++){
            t[i]=new Thread(new Runnable(){
                @Override
                public void run(){
                    for(int i=0;i<2000;i++){
                        increase();
                    }
                }
            });
            t[i].start();
        }
//等待所有累加线程都结束
        while(Thread.activeCount()>1) {
            Thread.yield();
            System.out.println(race);
        }
    }

}

