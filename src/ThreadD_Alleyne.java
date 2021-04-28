import java.io.*;

public class ThreadD_Alleyne extends Thread {

    // to write Objects
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    // to write raw bytes
    private InputStream is;
    private OutputStream os;
    private OutputStream os2;


    public ThreadD_Alleyne(OutputStream os, InputStream is, OutputStream os2) {
        this.is = is;
        this.os = os;
        this.os2 = os2;
    } // end CONSTRUCTOR

    public void run() {
//	  TD sends PRIMITIVE data to TA. 

        int somePrimitive = 100;


        System.out.println("ThreadD_Alleyne starting execution.");

        try {
            int somePrimitive2 = is.read();

            System.out.println("[ ThreadD_Alleyne receiving primitive from ThreadC_Alleyne ]");
            System.out.println("\tPrimitive from ThreadC_Alleyne: (" + somePrimitive2 + ")");


            Message_Alleyne m2 = new Message_Alleyne();
            m2.theMessage = "Object from ThreadD_Alleyne TO ThreadC_Alleyne reporting!";
            String[] s = {"134", "232", "333"};
            m2.someLines = s;
            m2.someNumber = 031;

            System.out.println();

            System.out.println("[ ThreadD_Alleyne sends object ]");
            System.out.println(m2);

            // let objects be transmitted across the pipe
            oos = new ObjectOutputStream(os2);
            oos.writeObject(m2);

            //write the primitive to the os
            os.write(somePrimitive);
            oos.flush();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
   
      
   } // end CLASS ThreadA_Alleyne

}