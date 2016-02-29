
import java.net.* ;
public class send extends Thread 
{
 
 int port;
 DatagramSocket socket;
 DatagramPacket packet;
 RecordPlayback playback;
 InetAddress host;
 

send( String h,int port,RecordPlayback playback) {  // send constructor
	  
      this.port = port;									// pass a port to the object
	  
	  
	  try
      {
		this.host = InetAddress.getByName(h);           // taking host ip
        this.socket = new DatagramSocket() ;			// creating a socket with ip and port.
		
	  }
     catch( Exception e2 )
     {
        System.out.println( e2 ) ;
		
     }
		
		this.playback = playback;
        this.packet =  new DatagramPacket(playback.tempBuffer2,playback.tempBuffer2.length,host,port);  // packet always acess playback object
			       
   }

	
	
   
   
   
   public void run() {         // overide the run method
      try
      {
         // Convert the argument to ensure that is it valid
		
         for( ;; )
         {
			playback.capture();  // capture audio and store in the byte array in object playback
			socket.send( packet );   // send stored byte array
			
	       }  
     }
     catch( Exception e )
     {
        System.out.println( e ) ;
		
     }
   }
   
}