/**
 * @Title: AbstractUrlHunter.java
 * @Package crawler.test.url.manager
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-3-11 下午2:58:46
 * @version V1.0
 */
package crawler.test.url.hunter;

import crawler.test.url.mintor.IUrlOriginMintor;
import crawler.test.url.reader.IUrlReader;

/**
 * @ClassName: AbstractUrlHunter
 * @Description: TODO
 * 
 */
public abstract class AbstractUrlHunter {
	protected IUrlReader urlReader = null;
	protected IUrlOriginMintor urlMintor = null;

	protected AbstractUrlHunter() {
		startHunt();
	}

	protected abstract IUrlReader createUrlReader();

	protected abstract IUrlOriginMintor createUrlMintor();

	public void startHunt() {
		IUrlOriginMintor urlOriginMintor = createUrlMintor();
		urlOriginMintor.registerListeners(createUrlReader());
		new Thread(urlOriginMintor).start();
	}

}
