package com.linksreader.app;

/**
 * Read URL links and find max count of a URL at any given point
 * The input will have timestamp, URL and count.  
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if (args.length < 1)
        {
                System.out.println("Usage: <filename>");
                return;
        }
     LinksReader lr =  new LinksReader();
     lr.readAndStore(args[0]);
     lr.printURLHit();     
    }
}
