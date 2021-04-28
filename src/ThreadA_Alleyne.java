import java.io.*;

public class ThreadA_Alleyne extends Thread {

    // to write Objects
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    // to write raw bytes
    private InputStream is;
    private OutputStream os;
    private InputStream threadB_threadA_PIS;
    private InputStream threadD_threadA_PIS;


    public ThreadA_Alleyne(PipedOutputStream os, PipedInputStream is, ObjectInputStream ois, InputStream threadB_threadA_PIS, InputStream threadD_threadA_PIS) {
        this.os = os;
        this.is = is;
        this.threadB_threadA_PIS = threadB_threadA_PIS;
        this.threadD_threadA_PIS = threadD_threadA_PIS;

    } // end CONSTRUCTOR

    public void run() {
        System.out.println("ThreadA_Alleyne starting execution.");

        //Primitive to send to ThreadA
        int somePrimitive = 200;

        try {

            //read object stream from ThreadB
            ois = new ObjectInputStream(threadB_threadA_PIS);
            Message_Alleyne m2 = (Message_Alleyne) ois.readObject();

            
            System.out.println();
            System.out.println("[ ThreadA_Alleyne receiving message from ThreadB_Alleyne ]");
            System.out.println(m2);


            System.out.println();

            //write primitive to thread C
            System.out.println("[ ThreadA_Alleyne sent: (" + somePrimitive + ") to ThreadC_Alleyne ]");
            os.write(somePrimitive);
            System.out.println();


            int somePrimitive2 = threadD_threadA_PIS.read();

            //read  primitive from thread D
            System.out.println();
            System.out.println("[ ThreadA_Alleyne receiving message from ThreadD_Alleyne ]");
            System.out.println(" Primitive from ThreadD_Alleyne: (" + somePrimitive2 + ")");
            System.out.println();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        // end METHOD run

    } // end CLASS ThreadA_Alleyne

}
