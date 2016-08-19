/**
 * @Title: IUrlMintor.java
 * @Package crawler.test.mintor
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-3-11 下午2:19:00
 * @version V1.0
 */
package crawler.test.url.mintor;

import crawler.test.url.reader.IUrlChangeListener;

/**
 * @ClassName: IUrlMintor
 * @Description: TODO
 * 
 */
public interface IUrlOriginMintor extends Runnable {
	public void registerListeners(IUrlChangeListener listener);
}
