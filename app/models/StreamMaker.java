package models;

import java.io.PipedOutputStream;

public class StreamMaker extends Thread {
	
    PipedOutputStream pos;

    public StreamMaker( PipedOutputStream pos) {
      super();
      this.pos = pos;
    }

    public void run(){
    	try {
            MyAPI.getData(pos);
            pos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
