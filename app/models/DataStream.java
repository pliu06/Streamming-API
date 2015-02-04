package models;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import play.mvc.Results.Chunks;

public class DataStream {
	static InputStream is;
	public static void run(Chunks.Out<String> out){
		for(int i = 0 ;i<10000 ; ++i){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
			int count = 0;
			while(count++<2000){
				out.write("<script>console.log('TEST' " + i + "'\n')</script>");
			}
			
		}

	}
//	
//	static byte[] sample = "Any String you want".getBytes();
//	
//	public static InputStream repeat( int times ) {
//		if (times <= 1) {
//			return new ByteArrayInputStream(sample);
//		
//		} else {
//
//			return new SequenceInputStream(
//
//				new ByteArrayInputStream(sample),
//
//						repeat( times-1)
//
//			);
//
//		}
//	}
	
	static byte[] sample = "Any String you want".getBytes();
	public static InputStream repeat(int times){

		if (times <= 1) {
			return new ByteArrayInputStream(sample);
		
		} else {
			System.out.println(times);
			return new SequenceInputStream(

				new ByteArrayInputStream(sample),

						repeat( times-1)

			);

		}
		
	}

}
