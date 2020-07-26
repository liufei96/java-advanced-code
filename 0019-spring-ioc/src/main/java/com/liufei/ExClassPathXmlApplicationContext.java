package com.liufei;

import com.liufei.annotation.ExResource;
import com.liufei.annotation.ExService;
import com.liufei.utils.ClassUtil;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: liufei
 * @Date: 2020/07/25/12:11 下午
 * @Description:
 */
public class ExClassPathXmlApplicationContext {

    // 扫包范围
    private String packageName;

    private ConcurrentHashMap<String, Object> beans = null;

    public ExClassPathXmlApplicationContext(String packageName) throws Exception {
        beans = new ConcurrentHashMap<>();
        this.packageName = packageName;
        initBeans();
        // 初始化类中的属性
        for(Map.Entry<String,Object> entry : beans.entrySet()) {
            Object value = entry.getValue();
            initFields(value);
        }
    }

    // 初始化对象
    public  void initBeans() throws Exception {
        // 1.使用java反射机制扫包，获取当前包下的所有类
        List<Class<?>> classes = ClassUtil.getClasses(packageName);
        // 2. 判断类上是否存在注入bean的注解
        ConcurrentHashMap<String, Object> classExistAnnotation = findClassExistAnnotation(classes);
        if (classExistAnnotation == null || classExistAnnotation.isEmpty()) {
            throw new Exception("改包下没有任何类的注解");
        }
    }

    public void initFields(Object object) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields) {
            ExResource exResource = field.getAnnotation(ExResource.class);
            if (exResource != null) {
                field.setAccessible(true);
                String beanId = field.getName();
                Object newInstall = getBean(beanId);
                if (newInstall != null) {
                    field.set(object, newInstall);
                }
            }
        }
    }

    public Object getBean(String beanId) throws Exception {
        if (StringUtils.isBlank(beanId)) {
            throw new Exception("beanId不能为空");
        }
        Object object = beans.get(beanId);
        return object;
    }

    // 判断类上是否有注入bean的注解
    public ConcurrentHashMap<String, Object> findClassExistAnnotation(List<Class<?>> classes) throws IllegalAccessException, InstantiationException {
        for (Class<?> aClass: classes) {
            ExService exService = aClass.getDeclaredAnnotation(ExService.class);
            if (exService != null) {
                // bean的id是类名小写
                String beanId = toLowerCaseFirstOne(aClass.getSimpleName());
                Object newInstance = aClass.newInstance();
                beans.put(beanId, newInstance);
                continue;
            }
        }
        return beans;
    }

    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.liufei.entity.User");
        System.out.println(aClass.getSimpleName());
    }
}
