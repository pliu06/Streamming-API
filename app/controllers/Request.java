package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import play.libs.Comet;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import play.mvc.With;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import play.mvc.Http.Response;

import models.MyAPI;
import models.StreamMaker;
import models.StringMaker;


public class Request extends Controller {


	/* Streaming api to send out an infinite string */
	public static Result pullString(){

		// Prepare a chunked text stream
		Chunks<String> chunks = new StringChunks() {
		    
			// Called when the stream is ready
		    public void onReady(Chunks.Out<String> out) {
		    	Thread sourceThread = new StringMaker(out);
		    	sourceThread.start();

		    }
		    
		};

		// Serves this stream with 200 OK
		return ok(chunks);
	   
	}
	
	
	
	/* Streaming api to send out an infinite stream */
	public static Result pullStream(){    
	      Thread readerThread = null;
	      try {
	          PipedOutputStream pos = new PipedOutputStream();
	          PipedInputStream pis = new PipedInputStream(pos); 
	          //Reading must be done in another thread
	          readerThread = new StreamMaker(pos);
	          readerThread.start();

	          return ok(pis);
	      } catch (Exception ex) {
	          ex.printStackTrace();
	          return internalServerError(ex.toString());

	      }
	  }

}
