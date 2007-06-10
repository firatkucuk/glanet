/**
 * 
 */
package org.gaplan.glanet;

import java.util.ArrayList;

/**
 * @author cafer
 *
 */
public class Users {
	public ArrayList<User> getList() {
		ArrayList<User> retval = new ArrayList<User>();
		
		User user = new User();
		user.setFullName("Cafer ŞİMŞEK");
		user.setEmail("cfb@cafer.org");
		user.setUrl("http://cfb.gaplan.org/");
		user.setUserName("cfb");
		user.setRssUrl("http://cfb.gaplan.org/feeds/posts/default?alt=rss");
		retval.add(user);
		
		user = new User();
		user.setFullName("Deniz KOÇAK");
		user.setEmail("deniz@gaplan.org");
		user.setUrl("http://deniz.gaplan.org/");
		user.setUserName("lenduha");
		user.setRssUrl("http://deniz.gaplan.org/feeds/posts/default?alt=rss");
		retval.add(user);
		
		user = new User();
		user.setFullName("Fırat KÜÇÜK");
		user.setEmail("firat@gaplan.org");
		user.setUrl("http://www.penguenyuvasi.org/");
		user.setUserName("pismikrop");
		user.setRssUrl("http://www.penguenyuvasi.org/feeds/posts/default?alt=rss");
		retval.add(user);
		
		user = new User();
		user.setFullName("Özgür KARATAŞ");
		user.setEmail("okaratas@ozgurkaratas.com");
		user.setUrl("http://www.ozgurkaratas.com/");
		user.setUserName("okaratas");
		user.setRssUrl("http://www.ozgurkaratas.com/index.php/feed/");
		retval.add(user);
		
		user = new User();
		user.setFullName("Talat UYARER");
		user.setEmail("talat@uyarer.com");
		user.setUrl("http://talat.uyarer.com/");
		user.setUserName("talat");
		user.setRssUrl("http://talat.uyarer.com/?feed=rss2");
		retval.add(user);
		
		user = new User();
		user.setFullName("Yılmaz UĞURLU");
		user.setEmail("metoikos@2nci.com");
		user.setUrl("http://www.2nci.com/");
		user.setUserName("metoikos");
		user.setRssUrl("http://www.2nci.com/wordpress/feed");
		retval.add(user);
		
		return retval;
	}
}
