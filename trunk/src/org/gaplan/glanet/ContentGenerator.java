package org.gaplan.glanet;

/* ************************************************************************** *\
 * Proje            / Project        : Glanet
 * Dosya            / File           : FetcherServlet.java
 * Lisans           / Licence        : GPL
 * Yazar            / Author         : Cafer ŞİMŞEK, Fırat KÜÇÜK
 * Son Güncelleme   / Last Update    : 15 Haz, 2007 Cum 00:09:16
 * Kodlama          / Encoding       : UTF-8
 * Satır Sonları    / Line Endings   : LF
 *
 * ==[TR]=======================================================================
 * TODO: Açıklama
 * ==[EN]=======================================================================
 * TODO: Description
 * =============================================================================
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 *
 * Copyright (C) 2007, Cafer ŞİMŞEK, Fırat KÜÇÜK
 * ----------------
 * http://www.gaplan.org/ | gaplan_at_gaplan.org
 *
\* ************************************************************************** */



// ### [TR] GEREKLİ SINIFLAR ###################################################
// ### [EN] REQUIRED CLASSES ###################################################

import java.net.URL;
import java.text.*;
import java.util.*;
import org.gnu.stealthp.rsslib.*;



// ### [TR] ContentGenerator SINIFI ############################################
// ### [EN] ContentGenerator CLASS #############################################

public class ContentGenerator extends TimerTask {



    // ### [TR] ALANLAR ########################################################
    // ### [EN] FIELDS #########################################################

    private boolean             isRuning;
    private Users               users;



    // ### [TR] METODLAR #######################################################
    // ### [EN] METHODS ########################################################

    // +++ [ContentGenerator] ++++++++++++++++++++++++++++++++++++++++++++++++++

    public ContentGenerator() {

        users = new Users();
    }



    // --- [run] ---------------------------------------------------------------

    public void run() {

        if (isRuning) {

            System.out.println("[Glanet] - Content Update Started..." + new Date());

            ArrayList<UserPost> tempPostList = new ArrayList<UserPost>();

            users.reload();

            for (User user : users.getList()) {
                System.out.println("[Glanet] - " + user.getUserName() +
                    " Content Generation Started!");
                tempPostList.addAll(fetchAll(user));
                System.out.println("[Glanet] - " + user.getUserName() +
                    " Content Generation Accomplished!");
            }

            Collections.sort(tempPostList, new Comparator<UserPost>() {
                public int compare(UserPost blogItem1, UserPost blogItem2) {

                    int returnValue = 0;

                    try {

                        DateFormat dateFormat = new SimpleDateFormat(
                            "EEE, dd MMM yyyy HH:mm:ss Z",
                            new Locale("en", "US")
                        );

                        Date date1 = dateFormat.parse(blogItem1.getRss().getPubDate()),
                             date2 = dateFormat.parse(blogItem2.getRss().getPubDate());

                        if (date1.getTime() < date2.getTime())
                            returnValue = 1;
                        else if (date1.getTime() > date2.getTime())
                            returnValue = -1;

                    } catch (Exception e) { e.printStackTrace(); }

                    return returnValue;
                }
            });

            ArrayList<UserPost> userPosts = FetcherServlet.getAllPosts();
            userPosts.clear();

            // TRUNCATING BLOG STREAM
            int count = 0;

            for (UserPost b : tempPostList) {
                if (count < 20) userPosts.add(b);
                else break;
                count++;
            }

            System.out.println("[Glanet] - Content Updated ! - " + new Date());
        }
    }



    // --- [setRuning] ---------------------------------------------------------

    public void setRuning(boolean state) {

        isRuning = state;
    }


    public static ArrayList<UserPost> fetchAll(User user) {

        ArrayList<UserPost> allPosts   = new ArrayList<UserPost>();
        RSSHandler          rssHandler = new RSSHandler();

        try {

            URL url = new URL(user.getFeedUrl());
            RSSParser.parseXmlFile(url, rssHandler, false);
        } catch(Exception e) { e.printStackTrace();}

        RSSChannel channel = rssHandler.getRSSChannel();
        LinkedList rssList = channel.getItems();

        for(int i = 0; i < rssList.size(); i++) {
            UserPost post = new UserPost();

            post.setRss((RSSItem)rssList.get(i));
            post.setUser(user);

            allPosts.add(post);
        }

        return allPosts;
    }
}
