package com.linksreader.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
 
import nl.basjes.parse.apachehttpdlog.ApacheHttpdLoglineParser;
import nl.basjes.parse.core.Parser;
import nl.basjes.parse.core.exceptions.DissectionFailure;
import nl.basjes.parse.core.exceptions.InvalidDissectorException;
import nl.basjes.parse.core.exceptions.MissingDissectorsException;

public class LinksReader {
	public static final int NUM_FIELDS = 9;
	String logformat = "%h %l %u %t \"%r\" %>s %O \"%{Referer}i\" \"%{User-Agent}i\"";
	MyRecord record = new MyRecord(); 
	static SortedSet<URLHit> tset = Collections.synchronizedSortedSet(new TreeSet<URLHit>(new URLNameComp()));
	boolean busy=false;
   /*
    * Function to read and store data from file
    * contains URL and count of URL hits
    */
   public void readAndStore(String file) {
       BufferedReader br = null;
             try {
                     String sCurrentLine;
                     br = new BufferedReader(new FileReader(file));
                     while ((sCurrentLine = br.readLine()) != null) {
                    	 Parser<MyRecord> parser = new ApacheHttpdLoglineParser<MyRecord>(MyRecord.class, logformat);
                    	 try {
                    		  record = parser.parse(record,sCurrentLine);
                    		} catch (DissectionFailure e) {
                    		  e.printStackTrace();
                    		} catch (InvalidDissectorException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (MissingDissectorsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                          sortedStore(record.getHttpURI());                    	 
                     }
                  } catch (IOException e) {
                     e.printStackTrace();
             } finally {
                     try {
                             if (br != null)br.close();
                     } catch (IOException ex) {
                             ex.printStackTrace();
                     }
             }           
     }

   //TODO-Object initialization will be enhanced
   protected void sortedStore(String url) {
	      boolean addNew = true;
	      if (tset.size() == 0)
		    tset.add(new URLHit(url,(Integer)1));
	      else {
	         for (Iterator<URLHit> iter = tset.iterator(); iter.hasNext(); ) {
	         synchronized (this) {
             URLHit uh = iter.next();
             if (uh.getURL().equalsIgnoreCase(url)) {	 
                  uh.setCnt(uh.getCnt()+1);
                  addNew = false;
                  break;
               } 
              }
	        }
	        if (addNew)
	        	tset.add(new URLHit(url,(Integer)1));   	
	      } 
     }
   
   public void printURLHit() {
	   System.out.println("URL Hit Count");
	   System.out.println("==============");
	   for(URLHit e:tset){
           System.out.println(e);
      }
    }      
}
