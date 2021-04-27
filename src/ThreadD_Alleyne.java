import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ThreadD_Alleyne extends Thread {

   // to write Objects
   private ObjectOutputStream oos;
   private ObjectInputStream  ois;

   // to write raw bytes
   private InputStream        is;
   private OutputStream       os;
    private InputStream        threadC_threadDis;




    public ThreadD_Alleyne(InputStream threadC_threadD) {
      this.is=threadC_threadD;

  
   } // end CONSTRUCTOR
   public void run ( ) {
//	  TD sends PRIMITIVE data to TA. 
	   
      int somePrimitive = 100;

       
      System.out.println( "ThreadD_Alleyne starting execution." );

      try {
          int somePrimitive2 = is.read();

          System.out.println("[ ThreadD_Alleyne receiving primitive from ThreadC_Alleyne ]");
          System.out.println("\tPrimitive from ThreadC_Alleyne: (" + somePrimitive2 + ")");
    	 

		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
   
      
   } // end CLASS ThreadA_Alleyne

}