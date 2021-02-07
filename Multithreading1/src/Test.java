
public class Test {
    public static void main(String[] args) {
        ReadThread readThread1 = new ReadThread("D:\\input1.csv");
        ReadThread readThread2 = new ReadThread("D:\\input2.csv");
        Thread t1 = new Thread(readThread1);
        Thread t2 = new Thread(readThread2);
        t1.start();
        t2.start();
    }
}
