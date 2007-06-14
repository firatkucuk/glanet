package org.gaplan.glanet;

/* ************************************************************************** *\
 * Proje            / Project        : Glanet
 * Dosya            / File           : User.java
 * Lisans           / Licence        : GPL
 * Yazar            / Author         : Cafer ŞİMŞEK, Fırat KÜÇÜK
 * Son Güncelleme   / Last Update    : 15 Haz, 2007 Cum 00:10:03
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



// ### [TR] User SINIFI ########################################################
// ### [EN] User CLASS #########################################################

public class User {



    // ### [TR] ALANLAR ########################################################
    // ### [EN] FIELDS #########################################################

    private String userName;
    private String blogUrl;
    private String fullName;
    private String feedUrl;
    private String email;
    private String avatarUrl;



    // ### [TR] METODLAR #######################################################
    // ### [EN] METHODS ########################################################

    // +++ [User] ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public User(String fullName) {

        this.fullName = fullName;
    }



    // --- [getUserName] -------------------------------------------------------

    public String getUserName() {

        return userName;
    }



    // --- [setUserName] -------------------------------------------------------

    public void setUserName(String userName) {

        this.userName = userName;
    }



    // --- [getBlogUrl] --------------------------------------------------------

    public String getBlogUrl() {

        return blogUrl;
    }



    // --- [setBlogUrl] --------------------------------------------------------

    public void setBlogUrl(String blogUrl) {

        this.blogUrl = blogUrl;
    }



    // --- [getFullName] -------------------------------------------------------

    public String getFullName() {

        return fullName;
    }



    // --- [getFeedUrl] --------------------------------------------------------

    public String getFeedUrl() {

        return feedUrl;
    }



    // --- [setFeedUrl] --------------------------------------------------------

    public void setFeedUrl(String feedUrl) {

        this.feedUrl = feedUrl;
    }



    // --- [getEmail] ----------------------------------------------------------

    public String getEmail() {

        return email;
    }



    // --- [setEmail] ----------------------------------------------------------

    public void setEmail(String email) {

        this.email = email;
    }



    // --- [getAvatarUrl] ------------------------------------------------------

    public String getAvatarUrl() {

        return avatarUrl;
    }



    // --- [setAvatarUrl] ------------------------------------------------------

    public void setAvatarUrl(String avatarUrl) {

        this.avatarUrl = avatarUrl;
    }
}
