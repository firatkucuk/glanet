package org.gaplan.glanet;

/* ************************************************************************** *\
 * Proje            / Project        : Glanet
 * Dosya            / File           : Users.java
 * Lisans           / Licence        : GPL
 * Yazar            / Author         : Cafer ŞİMŞEK, Fırat KÜÇÜK
 * Son Güncelleme   / Last Update    : 15 Haz, 2007 Cum 00:09:03
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

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;



// ### [TR] Users SINIFI #######################################################
// ### [EN] Users CLASS ########################################################

public class Users {



    // ### [TR] ALANLAR ########################################################
    // ### [EN] FIELDS #########################################################

    private Properties properties = new Properties();



    // ### [TR] METODLAR #######################################################
    // ### [EN] METHODS ########################################################

    // --- [reload] ------------------------------------------------------------

    public void reload() {

        ArrayList<User> users = new ArrayList<User>();

        try {

            FileInputStream stream = new FileInputStream(FetcherServlet.getPropertiesPath());
            properties.load(stream);
            stream.close();
        } catch (Exception ex) { ex.printStackTrace(); }

        User user;
        int  userNumber = 1;

        while ((user = getBlogUser(userNumber)) != null) {
            users.add(user);
            userNumber++;
        }

        FetcherServlet.setUserList(users);
    }



    // --- [getList] -----------------------------------------------------------

    public ArrayList<User> getList() {

        return FetcherServlet.getUserList();
    }



    // --- [getBlogUser] -------------------------------------------------------

    public User getBlogUser(int number) {

        String userFullName = properties.getProperty("user" + number + ".fullName");

        if (userFullName == null) return null;

        User user = new User(userFullName);
        user.setEmail(properties.getProperty("user" + number + ".email"));
        user.setBlogUrl(properties.getProperty("user" + number + ".blogURL"));
        user.setFeedUrl(properties.getProperty("user" + number + ".feedURL"));
        user.setUserName(properties.getProperty("user" + number + ".userName"));
        user.setAvatarUrl(properties.getProperty("user" + number + ".avatarURL"));

        return user;
    }
}
