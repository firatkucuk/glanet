/**
 * 
 */
package org.gaplan;

import java.util.Map;

import javax.faces.context.FacesContext;

/**
 * @author cafer
 *
 */
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

	/**
	 * @return the currentTheme
	 */
	public String getCurrentTheme() {
		return currentTheme;
	}

	/**
	 * @param currentTheme the currentTheme to set
	 */
	public void setCurrentTheme(String currentTheme) {
		this.currentTheme = currentTheme;
	}
}
