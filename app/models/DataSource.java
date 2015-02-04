package models;

import play.mvc.Results.Chunks;

public class DataSource extends Thread{
	
	Chunks.Out<String> out ;

	public DataSource(Chunks.Out<String> out){
		
		this.out = out;
	}
	
	public void run(){
		
		int count = 0;
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(count);
			out.write(String.valueOf(count++));
		}
	}
	
	
}
