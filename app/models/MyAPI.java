package models;

import java.io.IOException;
import java.io.PipedOutputStream;

import play.mvc.Results.Chunks;

public class MyAPI {
	
	
	public static void getData(PipedOutputStream pos){
		
		while(true){
			try {
				for(int i = 0; i<10000; i++){
					pos.write(i);
				}
				System.out.println("Sent out 10000 numbers");
				pos.flush();			
				Thread.sleep(2000);			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public static void getString(Chunks.Out<String> out) throws IOException, InterruptedException{
		long j = 0;
		while(true){
			for(int i = 0; i<10000; i++){
				out.write("tell me something I don't know !!  " + String.valueOf(j++)  + "\n"  );
			}
			System.out.println("Sent out 10000 lines");
			Thread.sleep(2000);
		}
	}
}
