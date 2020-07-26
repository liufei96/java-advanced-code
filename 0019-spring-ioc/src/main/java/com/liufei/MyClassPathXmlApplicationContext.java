package com.liufei;

import com.liufei.utils.XmlUtils;
import org.dom4j.Element;

import java.util.List;

/**
 * @Auther: liufei
 * @Date: 2020/07/19/6:43 下午
 * @Description:
 */
public class MyClassPathXmlApplicationContext {

    private String xmlPath;

    public MyClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Object getBean(String beanId) throws Exception {
        // 1.读取配置文件
        List<Element> elements = XmlUtils.readerXml(xmlPath);
        if (elements == null) {
            throw new Exception("该配置文件没有子元素");
        }
        // 2.使用beanId查找对应的class对象
        String xmlByIDClass = XmlUtils.findXmlByIDClass(elements, beanId);
        if (xmlByIDClass == null) {
            throw new Exception("没有找到改beanId对应的class");
        }
        // 3. 获取class的信息地址，使用反射进行初始化
        Class<?> aClass = Class.forName(xmlByIDClass);
        return aClass.newInstance();
    }
}
