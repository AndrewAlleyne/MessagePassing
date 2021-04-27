import java.io.*;

public class ThreadC_Alleyne extends Thread {

   // to write Objects
   private ObjectOutputStream oos;
   private ObjectInputStream  ois;

   // to write raw bytes
   private InputStream        is;

   private OutputStream       os;
   private OutputStream       threadC_threadB_POS;
   private InputStream        threadB_threadC_PIS;
   private OutputStream       threadC_threadD_POS;


   public ThreadC_Alleyne(InputStream is, InputStream threadB_threadC_PIS, PipedOutputStream threadC_threadD_POS) {
      this.is=is;
      this.threadB_threadC_PIS = threadB_threadC_PIS;
      this.threadC_threadD_POS = threadC_threadD_POS;

   } // end CONSTRUCTOR

   public void run ( ) {
      System.out.println( "ThreadC_Alleyne starting execution." );
      
      try {


         int somePrimitive = is.read();
         System.out.println();
         System.out.println("[ ThreadC_Alleyne receiving primitive from ThreadA_Alleyne ]");
         System.out.println("\tPrimitive from ThreadA_Alleyne: (" + somePrimitive + ")");

         int somePrimitive2 = 150;
         System.out.println();
         System.out.println("[ ThreadC_Alleyne sending primitive to ThreadD_Alleyne ]");
         System.out.println("\tPrimitive sent to ThreadD_Alleyne: (" + somePrimitive2 + ")");
         threadC_threadD_POS.write(somePrimitive2);
         System.out.println();





	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
} // end CLASS ThreadA_Alleyne

}