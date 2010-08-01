package com.atom.server;

import java.net.URL;
import java.util.Iterator;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

	
public class RSSReader {
	
	private static RSSReader instance = null;
		
		private RSSReader() {
		}
		public static RSSReader getInstance() {
			if(instance == null) {
				instance = new RSSReader();	
			}
			return instance;
		}
	 
	public String writeNews() {
	 
		String result[] = null;
		String result1 = "Titles\n";
	    URL url;
		try {
			url = new URL("http://adwordsapi.blogspot.com/atom.xml");
		
	    XmlReader reader = null;
	 
	    
			reader = new XmlReader(url);
		
	      SyndFeed feed = new SyndFeedInput().build(reader);
	     for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
	    	 SyndEntry entry = (SyndEntry) i.next();
	    	 result1 += entry.getTitle() + "\n";
	    	 
	        //System.out.println(entry.getTitle());
	           
	        }
	     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result1;
	    }
	
	
		}


