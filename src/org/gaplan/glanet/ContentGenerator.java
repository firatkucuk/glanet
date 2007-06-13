package org.gaplan.glanet;

/* ************************************************************************** *\
 * Proje            / Project        : Glanet
 * Dosya            / File           : ContentGenerator.java
 * Lisans           / Licence        : GPL
 * Yazar            / Author         : Cafer ŞİMŞEK, Fırat KÜÇÜK
 * Son Güncelleme   / Last Update    : 14 Haz, 2007 Prş 01:54:22
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.TimerTask;



// ### [TR] ContentGenerator SINIFI ############################################
// ### [EN] ContentGenerator CLASS #############################################

public class ContentGenerator extends TimerTask {



    // ### [TR] ALANLAR ########################################################
    // ### [EN] FIELDS #########################################################

    private ArrayList<BlogItem>  items;
    private boolean              run;



    // ### [TR] METODLAR #######################################################
    // ### [EN] METHODS ########################################################

    // +++ [ContentGenerator] ++++++++++++++++++++++++++++++++++++++++++++++++++

    public ContentGenerator(ArrayList<BlogItem> items) {
        this.items = items;
    }



    // --- [run] ---------------------------------------------------------------

    public void run() {
        if (isRun()) {
            System.out.println("content update stared..." + new Date());
            ArrayList<BlogItem> tempList = new ArrayList<BlogItem>();
            Users users = new Users();
            for (User user : users.getList()) {
                System.out.println(user.getUserName() + " basladi");
                tempList.addAll(NewsController.fetchAll(user.getRssUrl(), user.getFullName(), user.getHeadUrl()));
                System.out.println(user.getUserName() + " bitti");
            }
            Collections.sort(tempList, new Comparator<BlogItem>() {
                public int compare(BlogItem o1, BlogItem o2) {
                    int retval = 0;
                    try {
                        String format = "EEE, dd MMM yyyy HH:mm:ss Z";
                        DateFormat df = new SimpleDateFormat(format, new Locale("en", "US"));
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

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
