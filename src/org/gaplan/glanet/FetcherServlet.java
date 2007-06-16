package org.gaplan.glanet;

/* ************************************************************************** *\
 * Proje            / Project        : Glanet
 * Dosya            / File           : FetcherServlet.java
 * Lisans           / Licence        : GPL
 * Yazar            / Author         : Cafer ŞİMŞEK, Fırat KÜÇÜK
 * Son Güncelleme   / Last Update    : 15 Haz, 2007 Cum 00:09:27
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

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;



// ### [TR] FetcherServlet SINIFI ##############################################
// ### [EN] FetcherServlet CLASS ###############################################

public class FetcherServlet extends HttpServlet {



    // ### [TR] ALANLAR ########################################################
    // ### [EN] FIELDS #########################################################

    private static       ArrayList<UserPost> allPosts         = new ArrayList<UserPost>();
    private static       ArrayList<User>     userList         = new ArrayList<User>();
    private static       String              propertiesPath;
    private static final long                serialVersionUID = 1807930740483845702L;
    private              Timer               timer            = new Timer();
    private              ContentGenerator    contentGenerator;



    // ### [TR] METODLAR #######################################################
    // ### [EN] METHODS ########################################################

    // --- [init] --------------------------------------------------------------

    public void init() throws ServletException {

        message("Initializing FetcherServlet ...");

        propertiesPath = this.getServletContext().getRealPath("") +
            "/WEB-INF/glanet.properties";

        contentGenerator = new ContentGenerator();
        timer.scheduleAtFixedRate(contentGenerator, 20000, 5 * 60000);

        message("FetcherServlet initialized!");

        contentGenerator.setRuning(true);
    }



    // --- [destroy] -----------------------------------------------------------

    public void destroy() {

        contentGenerator.setRuning(false);
        timer.cancel();
        message("Fetch Timer Cancelled!");
    }



    // --- [getUserList] -------------------------------------------------------

    public static ArrayList<User> getUserList() {

        return userList;
    }



    // --- [setUserList] -------------------------------------------------------

    public static void setUserList(ArrayList<User> users) {

        userList = users;
    }



    // --- [getPropertiesPath] -------------------------------------------------

    public static String getPropertiesPath() {

        return propertiesPath;
    }



    // --- [getAllPosts] -------------------------------------------------------

    public static ArrayList<UserPost> getAllPosts() {

        return allPosts;
    }



    // --- [setAllPosts] -------------------------------------------------------

    public static void setAllPosts(ArrayList<UserPost> aAllPosts) {

        allPosts = aAllPosts;
    }



    // --- [message] -----------------------------------------------------------

    public static void message(String messageString) {

        // TODO: System.out may be optional according to glanet properties file.
        System.out.println("[Glanet] - " + new Date() + " - " + messageString);
    }
}
