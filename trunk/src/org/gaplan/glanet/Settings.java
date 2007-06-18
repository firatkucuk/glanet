package org.gaplan.glanet;

/* ************************************************************************** *\
 * Proje            / Project        : Glanet
 * Dosya            / File           : Settings.java
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

import java.util.Map;
import javax.faces.context.FacesContext;



// ### [TR] Settings SINIFI ##############################################
// ### [EN] Settings CLASS #####################################################

public class Settings {



    // ### [TR] ALANLAR ########################################################
    // ### [EN] FIELDS #########################################################

    private String currentTheme;



    // ### [TR] METODLAR #######################################################
    // ### [EN] METHODS ########################################################

    // +++ [Settings] ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public Settings() {

        this.currentTheme = "turuncu";
    }



    // --- [changeTheme] -------------------------------------------------------

    public String changeTheme() {

        Map params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        setCurrentTheme((String) params.get("theme"));
        return "ok";
    }



    // --- [getThemes] ---------------------------------------------------------

    public String[] getThemes() {

        String[] retval = new String[] {
            "turuncu",
            "kahve",
            "lacivert",
            "mavi",
            "yesil"
        };

        return retval;
    }



    // --- [getCurrentTheme] ----------------------------------------------------

    public String getCurrentTheme() {

        return currentTheme;
    }



    // --- [setCurrentTheme] ---------------------------------------------------

    public void setCurrentTheme(String currentTheme) {

        this.currentTheme = currentTheme;
    }
}
