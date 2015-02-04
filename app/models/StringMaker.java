package models;

import play.mvc.Results.Chunks;


public class StringMaker extends Thread {
	Chunks.Out<String> out;
    public StringMaker( Chunks.Out<String> out) {
	        super();
	        this.out = out;
	    }
    public void run(){
          try {
              MyAPI.getString(out);
              out.close();
          } catch (Exception ex) {
              ex.printStackTrace();
          }
    }	
}
