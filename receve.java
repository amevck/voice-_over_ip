

 
 import java.net.* ;
public class receve extends Thread {

 
 int port;
 DatagramSocket socket;
 DatagramPacket packet;
 RecordPlayback playback;
 InetAddress host;
 
  
  
  receve( int port,RecordPlayback playback) {              // this is the constructor
	  
      this.port = port;	
	  try
      {
        this.socket = new DatagramSocket( this.port ) ;    // ssign a socket
		
	  }
     catch( Exception e2 )
      {
        System.out.println( e2 ) ;
		
      }
		
		this.playback = playback;
        this.packet = new DatagramPacket( playback.tempBuffer1,playback.tempBuffer1.length );  // packet always acess the play back object and store byte array
	}
   
   
   
   public void run() {
      try
      {
         // Convert the argument to ensure that is it valid
         for( ;; )
         {
			socket.receive( packet );     //receve packet and store in playback object
			playback.play();			  // play the stored packet
			
	       }  
     }
     catch( Exception e )
     {
        System.out.println( e ) ;
		
     }
   }
   
}
