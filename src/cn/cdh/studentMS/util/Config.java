package cn.cdh.studentMS.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Config {
	public static NodeList dbCongig() {
		Element element = null;
		File file = new File("config.xml");
		// documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
		DocumentBuilder db = null;
		DocumentBuilderFactory dbf = null;
		try {
			// 返回documentBuilderFactory对象
			dbf = DocumentBuilderFactory.newInstance();
			// 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
			db = dbf.newDocumentBuilder();
			// 得到一个DOM并返回给document对象
			Document dt = db.parse(file);
			// 得到一个elment根元素
			element = dt.getDocumentElement();
			NodeList nl = element.getChildNodes();
			return nl;
		} catch (Exception e) {
			return null;
		}
	}
}
