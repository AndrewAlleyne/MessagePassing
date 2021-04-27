import java.io.*;
import java.nio.channels.Pipe;

public class ThreadA_Alleyne extends Thread {

    // to write Objects
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    // to write raw bytes
    private InputStream is;
    private OutputStream os;
    private InputStream threadB_threadA_PIS;


    public ThreadA_Alleyne(PipedOutputStream os, PipedInputStream is, ObjectInputStream ois, InputStream threadB_threadA_PIS) {
        this.os = os;
        this.is = is;
        this.ois = ois;
        this.threadB_threadA_PIS = threadB_threadA_PIS;

    } // end CONSTRUCTOR

    public void run() {
        System.out.println("ThreadA_Alleyne starting execution.");

        //Thread A sends primitive data to thread C
        int somePrimitive = 200;

        try {

            ois = new ObjectInputStream ( threadB_threadA_PIS );
            Message_Alleyne m2 = (Message_Alleyne) ois.readObject();
            System.out.println();
            System.out.println("[ ThreadA_Alleyne receiving message from ThreadB_Alleyne ]");
            System.out.println(m2);

            os.write(somePrimitive);
            System.out.println("[ ThreadA_Alleyne sent: (" + somePrimitive + ") to ThreadC_Alleyne ]");
            System.out.println();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        // end METHOD run

    } // end CLASS ThreadA_Alleyne

}
