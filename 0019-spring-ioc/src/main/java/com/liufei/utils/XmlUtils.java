package com.liufei.utils;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: liufei
 * @Date: 2020/07/19/6:38 下午
 * @Description:
 */
public class XmlUtils {

    public static void main(String[] args) throws DocumentException {
        XmlUtils xmlUtils = new XmlUtils();
        xmlUtils.test001();
    }

    public void test001() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(getClassPath("student.xml"));
        // 获取根节点
        Element rootElement = read.getRootElement();
        getNodes(rootElement);
    }

    public static InputStream getClassPath(String xmlPath) {
        InputStream resourceAsStream = XmlUtils.class.getClassLoader().getResourceAsStream(xmlPath);
        return resourceAsStream;
    }

    public static void getNodes(Element rootElement) {
        System.out.println("获取当前名称:" + rootElement.getName());
        // 获取属性信息
        List<Attribute> attributes = rootElement.attributes();
        for (Attribute attribute : attributes) {
            System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
        }
        // 获取属性value
        String value = rootElement.getTextTrim();
        if (!StringUtils.isEmpty(value)) {
            System.out.println("value:" + value);
        }
        // 使用迭代器遍历,继续遍历子节点
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element next = elementIterator.next();
            getNodes(next);
        }
    }

    // 读取xml配置文件
    public static List<Element> readerXml(String xmlPath) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        if (StringUtils.isBlank(xmlPath)) {
            new Exception("xml路径不能为空");
        }
        Document root = saxReader.read(getClassPath(xmlPath));
        // 获取根节点
        Element rootElement = root.getRootElement();
        List<Element> elements = rootElement.elements();
        if (elements == null || elements.isEmpty()) {
            return null;
        }
        return elements;
    }

    public static String findXmlByIDClass(List<Element> elements, String beanId) throws Exception {
        for (Element element : elements) {
            String beanIdValue = element.attributeValue("id");
            if (beanIdValue == null) {
                throw new Exception("使用该beanId没有查找到对应的元素");
            }
            if (!beanIdValue.equals(beanId)) {
                continue;
            }
            // 获取Class地址属性
            String classPath = element.attributeValue("class");
            if (StringUtils.isNotBlank(classPath)) {
                return classPath;
            }
        }
        return null;
    }
}
