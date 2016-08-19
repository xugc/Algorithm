/**
 * @Title: IUrlReader.java
 * @Package crawler.test.url
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-3-11 上午11:09:31
 * @version V1.0
 */
package crawler.test.url.reader;

import java.util.Set;

/**
 * @ClassName: IUrlReader
 * @Description: TODO
 * 
 */
public interface IUrlReader extends IUrlChangeListener {
	/**
	 * @Title: getUrls
	 * @Description: 获取所有请求url
	 * @return 请求url列表
	 * @return List<String> 返回类型
	 * @throws
	 */
	public Set<String> getUrls();
}
