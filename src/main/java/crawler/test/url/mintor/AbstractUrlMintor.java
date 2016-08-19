/**
 * @Title: AbstractUrlMintor.java
 * @Package crawler.test.url.mintor
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-3-11 下午3:49:10
 * @version V1.0
 */
package crawler.test.url.mintor;

import java.util.ArrayList;
import java.util.List;

import crawler.test.url.reader.IUrlChangeListener;

/**
 * @ClassName: AbstractUrlMintor
 * @Description: TODO
 * 
 */
public abstract class AbstractUrlMintor implements IUrlOriginMintor {

	private List<IUrlChangeListener> listeners = new ArrayList<IUrlChangeListener>();

	@Override
	public void run() {
		startMintor();
	}

	protected abstract void startMintor();

	@Override
	public void registerListeners(IUrlChangeListener listener) {
		listeners.add(listener);
	}

	protected void notifyAllListeners() {
		for (IUrlChangeListener l : listeners) {
			l.change();
		}
	}

}
