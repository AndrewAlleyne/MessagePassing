import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ThreadB_Alleyne extends Thread {

   // to write Objects
   private ObjectOutputStream oos;
   private ObjectInputStream  ois;

   // to write raw bytes
   private InputStream        is;
   private OutputStream       os;
   private OutputStream       os2;


   public ThreadB_Alleyne (ObjectOutputStream oos, OutputStream os, OutputStream os2)
   {
       this.oos = oos;
       this.os = os;
       this.os2 = os2;
   } // end CONSTRUCTOR

   public void run ( ) {
      System.out.println( "ThreadB_Alleyne starting execution." );

      try {

    	 //SEND PRIMITIVE TO TC
    	  int somePrimitive = 23; 
    	  os.write(somePrimitive);

          System.out.println();
          System.out.println("[ ThreadB_Alleyne sending primitive: (" + somePrimitive + ")  to ThreadC_Alleyne ]");
          System.out.println();


          /*Creates the message and then sends using the ObjectOutputStream*/
          Message_Alleyne m2 = new Message_Alleyne();
          m2.theMessage = "Object from ThreadB_Alleyne TO ThreadA_Alleyne reporting!";
          String[] s = {"430", "203", "892"};
          m2.someLines = s;
          m2.someNumber= 030;

          System.out.println("[ ThreadB_Alleyne sends object ]");
          System.out.println(  m2 );

          // let objects be transmitted across the pipe
          oos = new ObjectOutputStream(os2);
          oos.writeObject( m2 );

          oos.flush();

        //END OF OBJECT TO TC
          
      } // end TRY
      catch ( Exception exc ) {
            System.out.println
                  ( "Error ThreadB_Alleyne: " + exc );
      } // end CATCH

   } // end METHOD run

} // end CLASS ThreadB_Alleyne
