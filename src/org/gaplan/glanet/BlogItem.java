/**
 * 
 */
package org.gaplan.glanet;

/**
 * @author cafer
 *
 */
public class BlogItem {
	private String channelUrl;
	private String channelDescription;
	private String channelTitle;
	private String author;
	private String title;
	private String link;
	private String date;
	private String description;
        private String content;

	/**
	 * @return the channelUrl
	 */
	public String getChannelUrl() {
		return channelUrl;
	}
	/**
	 * @param channelUrl the channelUrl to set
	 */
	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
	}
	/**
	 * @return the channelDescription
	 */
	public String getChannelDescription() {
		return channelDescription;
	}
	/**
	 * @param channelDescription the channelDescription to set
	 */
	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}
	/**
	 * @return the channelTitle
	 */
	public String getChannelTitle() {
		return channelTitle;
	}
	/**
	 * @param channelTitle the channelTitle to set
	 */
	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
}
