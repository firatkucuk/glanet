package org.gaplan.glanet;

/* ************************************************************************** *\
 * Proje            / Project        : Glanet
 * Dosya            / File           : FetcherServlet.java
 * Lisans           / Licence        : GPL
 * Yazar            / Author         : Cafer ŞİMŞEK, Fırat KÜÇÜK
 * Son Güncelleme   / Last Update    : 14 Haz, 2007 Prş 01:32:50
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
import java.util.Timer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;



// ### [TR] FetcherServlet SINIFI ##############################################
// ### [EN] FetcherServlet CLASS ###############################################

public class FetcherServlet extends HttpServlet {



    // ### [TR] ALANLAR ########################################################
    // ### [EN] FIELDS #########################################################

    public  static       ArrayList<BlogItem> allBlogItems;
    private static final long                serialVersionUID = 1807930740483845702L;
    private              Timer               timer;
    private              ContentGenerator    contentGenerator;



    // ### [TR] METODLAR #######################################################
    // ### [EN] METHODS ########################################################

    // --- [init] --------------------------------------------------------------

    public void init() throws ServletException {
        System.out.println("Initializing Glanet's FetcherServlet ...");

        allBlogItems     = new ArrayList<BlogItem>();
        timer            = new Timer();
        contentGenerator = new ContentGenerator(allBlogItems);
        timer.scheduleAtFixedRate(contentGenerator, 20000, 5 * 60000);

        System.out.println("Glanet's FetcherServlet initialized !");

        contentGenerator.setRun(true);
    }



    // --- [destroy] -----------------------------------------------------------

    public void destroy() {
        contentGenerator.setRun(false);
        timer.cancel();
        System.out.println("Glanet Fetch Timer Cancelled!");
    }



    // --- [getAllItems] -------------------------------------------------------

    public static ArrayList<BlogItem> getAllItems() {
        return allBlogItems;
    }


    // --- [setAllItems] -------------------------------------------------------

    public static void setAllItems(ArrayList<BlogItem> items) {
        FetcherServlet.allBlogItems = items;
    }
}
