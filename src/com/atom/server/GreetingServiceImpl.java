package com.atom.server;

import java.net.URL;
import java.util.Iterator;

import com.atom.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) {
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		//RSSReader reader = RSSReader.getInstance();
		//return reader.writeNews().toString();
		//return output;
		//return "Hello, " + input + "!<br><br>I am running " + serverInfo
			//	+ ".<br><br>It looks like you are using:<br>" + userAgent;
		
		String result1 = "Titles\n";
	    URL url;
		try {
			url = new URL("http://adwordsapi.blogspot.com/atom.xml");
		
	    XmlReader reader = null;
	 
	    
			reader = new XmlReader(url);
		
	      SyndFeed feed = new SyndFeedInput().build(reader);
	     for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
	    	 SyndEntry entry = (SyndEntry) i.next();
	    	 result1 += "\n\n" + entry.getTitle() + "\n\n";
	    	 result1 += "\n\n--------------------------\n\n";
	    	 
	        //System.out.println(entry.getTitle());
	           
	        }
	     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result1;
	}
}
