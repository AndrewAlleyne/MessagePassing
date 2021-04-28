import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ConnectionManager_Alleyne {


    static private PipedInputStream threadA_threadC_PIS;
    static private PipedOutputStream threadA_threadC_POS;

    static private PipedInputStream threadB_threadA_PIS;
    static private PipedOutputStream threadB_threadA_POS;

    static private PipedInputStream threadB_threadC_PIS;
    static private PipedOutputStream threadB_threadC_POS;

    static private PipedInputStream threadC_threadA_PIS;
    static private PipedOutputStream threadC_threadA_POS;

    static private PipedInputStream threadC_threadD_PIS;
    static private PipedOutputStream threadC_threadD_POS;

    static private PipedInputStream threadD_threadA_PIS;
    static private PipedOutputStream threadD_threadA_POS;

    static private PipedInputStream threadD_threadC_PIS;
    static private PipedOutputStream threadD_threadC_POS;


    static private ObjectOutputStream oos;
    static private ObjectInputStream ois;

    public static void main(String[] argv) {
        try {

            //Thread A sends  to Thread C
            threadA_threadC_POS = new PipedOutputStream();
            threadA_threadC_PIS = new PipedInputStream(threadA_threadC_POS);

            //Thread C receives  from Thread A
            threadC_threadA_POS = new PipedOutputStream();
            threadC_threadA_PIS = new PipedInputStream(threadC_threadA_POS);

            //Thread B sends to ThreadA
            threadB_threadA_POS = new PipedOutputStream();
            threadB_threadA_PIS = new PipedInputStream(threadB_threadA_POS);

            //Thread B sends to ThreadC
            threadB_threadC_POS = new PipedOutputStream();
            threadB_threadC_PIS = new PipedInputStream(threadB_threadC_POS);

            //ThreadC sends primitive to ThreadD
            threadC_threadD_POS = new PipedOutputStream();
            threadC_threadD_PIS = new PipedInputStream(threadC_threadD_POS);

            //ThreadD sends to ThreadA
            threadD_threadA_POS = new PipedOutputStream();
            threadD_threadA_PIS = new PipedInputStream(threadD_threadA_POS);

            //ThreadD sends to ThreadC
            threadD_threadC_POS = new PipedOutputStream();
            threadD_threadC_PIS = new PipedInputStream(threadD_threadC_POS);


            System.out.println("Objects created for message passing");

            //Thread A writes to Thread C and reads an object from Thread B
            ThreadA_Alleyne TA = new ThreadA_Alleyne(threadA_threadC_POS, threadA_threadC_PIS, ois, threadB_threadA_PIS, threadD_threadA_PIS);

            //ThreadC sends to ThreadD but receives from ThreadA
            ThreadC_Alleyne TC = new ThreadC_Alleyne(threadA_threadC_PIS, threadB_threadC_PIS, threadC_threadD_POS, threadD_threadC_PIS);

            //Thread B sends object to ThreadA and a primitive to ThreadC
            ThreadB_Alleyne TB = new ThreadB_Alleyne(oos, threadB_threadC_POS, threadB_threadA_POS);

            //TD sends PRIMITIVE data to TA and OBJECTS to TC.
            ThreadD_Alleyne TD = new ThreadD_Alleyne(threadD_threadA_POS, threadC_threadD_PIS, threadD_threadC_POS);


            System.out.println("Thread execution");
            TA.start();
            TB.start();
            TC.start();
            TD.start();
        } // end TRY
        catch (Exception exc) {
            System.out.println(exc);
        } // end CATCH
   }

} // end CLASS ConnectionManager_Alleyne
