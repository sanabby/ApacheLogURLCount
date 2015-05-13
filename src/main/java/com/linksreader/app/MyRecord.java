package com.linksreader.app;
import nl.basjes.parse.core.Field;
public class MyRecord {
	    private static String httpURI;
	    private static String time;
	    
	    @Field({
	       "TIME.EPOCH:request.receive.time.epoch",
	       "STRING:connection.client.user",
	       "IP:connection.client.host",
	       "HTTP.METHOD:request.firstline.method",
	       "HTTP.URI:request.firstline.uri",
	       "HTTP.PATH:request.firstline.uri.path",
	       "HTTP.QUERYSTRING:request.firstline.uri.query",
	       "STRING:request.firstline.uri.query.*",
	       "HTTP.USERAGENT:request.user-agent",
	       "NUMBER:connection.client.logname",
	       "HTTP.URI:request.referer",
	       "HTTP.PATH:request.referer.path",
	       "STRING:request.referer.query.*",
	    })
	    
	    public void setValue(final String name, final String value) { 	
	      if (name.equalsIgnoreCase("HTTP.URI:request.referer"))
	    	  httpURI=value;
	      if (name.equalsIgnoreCase("TIME.EPOCH:request.receive.time.epoch"))
	    	  time=value;
	      }
	    
	    public String getHttpURI()
	    {
	    	return httpURI;
	    }
	    
	    public String getTime()
	    {
	    	return time;
	    }
   
}
