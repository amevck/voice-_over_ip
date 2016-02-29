/*
 *  A datagram send to send and receive UDP packets in Java.
 *
 *  Instructions to run:
 *  Pass the host address and the port as command line arguments.
 *  Eg: >>javac UDPClient.java
 *      >>java UDPClient hostaddress portNo
 */

 //import network and input output packages
 import java.net.* ;


public class UDPClient extends Thread
{
   //Give a standard packet size. 
   private final static int packetsize = 500 ;
   
   public static void main( String args[] )
   {
	   
	    if( args.length != 1 )
      {
         System.out.println( " error: enter ->  java UDPClient <recevers ip>" ) ; // giving error if not entered ip.
         return ;
      }

         int portr = 12345;   				// port to send data
		 int ports = 12346;					//port to receve data
									
		 String h = args[0];
		 RecordPlayback playback = new RecordPlayback();  // create the playback object
		 playback.captureAudio();
		 
		  new Thread(new send(h,portr,playback)).start();  // create and run data sending thread
		  new Thread(new receve(ports,playback)).start();  //create and run data receving thread
		
     
   }
}
