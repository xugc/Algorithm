/**
 * @Title: CrawlerUrl.java
 * @Package crawler.test.common
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-3-11 下午2:40:12
 * @version V1.0
 */
package crawler.test.common;

/**
 * @ClassName: CrawlerUrl
 * @Description: TODO
 * 
 */
public class CrawlerUrl {
	private String url;
	private boolean visited = false;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
