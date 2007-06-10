/**
 * 
 */
package org.gaplan.glanet;

import java.util.ArrayList;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author cafer
 *
 */
public class FetcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1807930740483845702L;
	public static ArrayList<BlogItem> allItems;
	private Timer timer;
	private ContentGenerator cg;
	
	public void init() throws ServletException {
		System.out.println("FetcherServlet init oluyor...");
		allItems = new ArrayList<BlogItem>();
		timer = new Timer();
		cg = new ContentGenerator(allItems);
		timer.scheduleAtFixedRate(cg, 20000, 5 * 60000);
		System.out.println("FetcherServlet init oldu...");
		cg.setRun(true);
	}
	
	public void destroy() {
		cg.setRun(false);
		timer.cancel();
		System.out.println("timer canceled");
	}

	/**
	 * @return the allItems
	 */
	public static ArrayList<BlogItem> getAllItems() {
		return allItems;
	}

	/**
	 * @param allItems the allItems to set
	 */
	public static void setAllItems(ArrayList<BlogItem> allItems) {
		FetcherServlet.allItems = allItems;
	}
}
