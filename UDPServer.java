

 
 import java.net.* ;
public class UDPServer
{
   //Give a standard packet size
   private final static int packetsize = 500 ;

	
	
   public static void main( String args[] )
   {
	   
	     if( args.length != 1 )
      {
         System.out.println( "error: enter ->  java UDPServer <recever's ip>" ) ; // giving error if not entered ip.
         return ;
      }
	  
		String h = args[0];
		RecordPlayback playback = new RecordPlayback(); // create playback object
		playback.captureAudio();                        // this must n=be called to configure and find the computers audioa hardware
      
         int portr = 12345;                             // port to receve data
		 int ports = 12346;								// port to send data
		 
		 new Thread(new receve(portr,playback)).start();  // create and start receving thread
		 new Thread(new send(h,ports,playback)).start();  // create and start data sending thread
	      
	        	 
	         	
     }
}
   
