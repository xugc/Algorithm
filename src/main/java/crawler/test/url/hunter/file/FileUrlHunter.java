/**
 * @Title: FileUrlHunter.java
 * @Package crawler.test.url.manager
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-3-11 下午2:53:59
 * @version V1.0
 */
package crawler.test.url.hunter.file;

import crawler.test.url.hunter.AbstractUrlHunter;
import crawler.test.url.mintor.IUrlOriginMintor;
import crawler.test.url.mintor.file.FileUrlMintor;
import crawler.test.url.reader.IUrlReader;
import crawler.test.url.reader.file.FileUrlReader;

/**
 * @ClassName: FileUrlHunter
 * @Description: TODO
 * 
 */
public class FileUrlHunter extends AbstractUrlHunter {

	public FileUrlHunter() {
		super();
	}

	@Override
	protected IUrlReader createUrlReader() {
		urlReader = FileUrlReader.getInstance();
		return urlReader;
	}

	@Override
	protected IUrlOriginMintor createUrlMintor() {
		urlMintor = new FileUrlMintor();
		return urlMintor;
	}
}
