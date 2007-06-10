/**
 * 
 */
package org.gaplan.glanet;

import java.util.ArrayList;

/**
 * @author cafer
 *
 */
public class Blogs {
	public ArrayList<BlogItem> getAll() {
		return FetcherServlet.getAllItems();
	}
}
