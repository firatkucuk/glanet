/**
 * 
 */
package org.gaplan.glanet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.TimerTask;

/**
 * @author cafer
 *
 */
public class ContentGenerator extends TimerTask {
	
	private ArrayList<BlogItem> items;
	private boolean run;
	
	public ContentGenerator(ArrayList<BlogItem> items) {
		this.items = items;
	}
	

	public void run() {
			if (isRun()) {
			System.out.println("content update stared..." + new Date());
			ArrayList<BlogItem> tempList = new ArrayList<BlogItem>();
			Users users = new Users();
			for (User user : users.getList()) {
				tempList.addAll(NewsController.fetchAll(user.getRssUrl(), user.getFullName()));
			}
			Collections.sort(tempList, new Comparator<BlogItem>() {
				public int compare(BlogItem o1, BlogItem o2) {
					int retval = 0;
					try {
						String format = "EEE, dd MMM yyyy HH:mm:ss Z";
						DateFormat df =	new SimpleDateFormat(format, new Locale("en", "US"));
						Date d1 = df.parse(o1.getDate());
						Date d2 = df.parse(o2.getDate());
						if (d1.getTime() < d2.getTime()) {
							retval = 1;
						}
						if (d1.getTime() > d2.getTime()) {
							retval = -1;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return retval;
				}
			});
			items.clear();
			int count = 0;
			for (BlogItem b : tempList) {
				if (count < 20) {
					items.add(b);
				} else {
					break;
				}
				count++;
			}
			System.out.println("content updated..." + new Date());
		}
	}


	/**
	 * @return the run
	 */
	public boolean isRun() {
		return run;
	}


	/**
	 * @param run the run to set
	 */
	public void setRun(boolean run) {
		this.run = run;
	}
}
