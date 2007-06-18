package org.gaplan.glanet;


/* ************************************************************************** *\
 * Proje            / Project        : Glanet
 * Dosya            / File           : UserPost.java
 * Lisans           / Licence        : GPL
 * Yazar            / Author         : Cafer ŞİMŞEK, Fırat KÜÇÜK
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

import org.gnu.stealthp.rsslib.RSSItem;



// ### [TR] UserPost SINIFI ####################################################
// ### [EN] UserPost CLASS #####################################################

public class UserPost {



    // ### [TR] ALANLAR ########################################################
    // ### [EN] FIELDS #########################################################

    private User    user;
    private RSSItem rss;



    // ### [TR] METODLAR #######################################################
    // ### [EN] METHODS ########################################################

    // --- [getUser] -----------------------------------------------------------

    public User getUser() {

        return user;
    }



    // --- [setUser] -----------------------------------------------------------

    public void setUser(User user) {

        this.user = user;
    }



    // --- [getRss] ------------------------------------------------------------

    public RSSItem getRss() {

        return rss;
    }



    // --- [setRss] ------------------------------------------------------------

    public void setRss(RSSItem rss) {

        this.rss = rss;
    }



    // --- [getContent] --------------------------------------------------------

    public String getContent() {

        return rss.toString();
    }
}
