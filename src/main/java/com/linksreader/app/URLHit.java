package com.linksreader.app;

import java.util.Comparator;

public class URLHit { 
	private String url;
	private int cnt;
     
    public URLHit(String url, Integer cnt){      
 	   this.url=url;
 	   this.cnt=cnt;
    }
    
    public int getCnt() {
    	return  cnt;	
    }
    
    public void setCnt(int cnt) {
    	 this.cnt = cnt;	
    }
    
    public String getURL()
    {
    	return url;
    }
    
    public String toString(){
        return "URL: "+this.url+ " --> Count: "+this.cnt;
    }
}

class URLNameComp implements Comparator<URLHit>{
    public int compare(URLHit e1, URLHit e2) {
        return e1.getURL().compareTo(e2.getURL());
    }
}  
 
class URLCntComp implements Comparator<URLHit> {
    public int compare(URLHit e1, URLHit e2) {
        if(e1.getCnt() == e2.getCnt()) {
            return 0;
        } else if(e1.getCnt() > e2.getCnt()){
        	return 1;
        } else {
            return -1;
        }
    }
 }

 
