/**
 * @Title: FileUrlReader.java
 * @Package crawler.test.url
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-3-11 上午11:13:20
 * @version V1.0
 */
package crawler.test.url.reader.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import crawler.test.url.reader.IUrlReader;

/**
 * @ClassName: FileUrlReader
 * @Description: TODO
 * 
 */
public class FileUrlReader implements IUrlReader {
	private final static String URL_FILE_PATH = "url/";
	private static Set<String> urlCache = new HashSet<String>();
	private final static FileUrlReader instance = new FileUrlReader();

	private FileUrlReader() {
		initUrl(URL_FILE_PATH);
	}

	public static FileUrlReader getInstance() {
		return instance;
	}

	private void initUrl(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			File[] children = file.listFiles();
			for (File child : children) {
				if (child.isDirectory()) {
					initUrl(child.getAbsolutePath());
				} else {
					readFile(child);
				}
			}
		} else {
			readFile(file);
		}
	}

	private void readFile(File file) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				urlCache.add(line.trim());
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	@Override
	public Set<String> getUrls() {
		return urlCache;
	}

	@Override
	public void change() {
		urlCache.clear();
		initUrl(URL_FILE_PATH);
	}

}
