package org.gaplan.glanet;

import java.util.Map;

import javax.faces.context.FacesContext;

@SuppressWarnings("unchecked")
public class Settings {
	private String currentTheme;

    public Settings() {
        this.currentTheme = "turuncu";
    }

    public String changeTheme() {
        Map params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        setCurrentTheme((String) params.get("theme"));
        return "ok";
    }

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

    public String getCurrentTheme() {
        return currentTheme;
    }

    public void setCurrentTheme(String currentTheme) {
        this.currentTheme = currentTheme;
    }
}
