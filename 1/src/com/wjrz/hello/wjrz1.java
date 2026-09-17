package com.wjrz.hello;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class wjrz1 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 xml文件");
        // 可扩展标记语言，本质是一种特殊的数据格式

        // xml特点：
        // 标签一般成对出现；标签名可自定义，但必须正确嵌套；
        // 根标签只有一个；标签可以有属性；文件名后缀是.xml

        // 本质是一种数据格式，可以存储复杂的数据结构，和数据关系
        // 应用场景：经常用来做为系统的配置文件；或者作为一种特殊的数据结构，在网络中进行传输

        System.out.println();
        System.out.println("2 解析xml文件");
        // Dom4j是一个解析xml的java库
        // Dom4j解析思想是文档对象模型

        SAXReader reader = new SAXReader(); // 创建SAXReader对象

        Document document = reader.read("1/src/com/wjrz/wjrz1/test.xml");

        Element root = document.getRootElement();
        System.out.println(root.getName());

        System.out.println();
        // 获取根元素下的全部一级子元素
        List<Element> users = root.elements();
        for (Element user : users) {
            System.out.println(user.getName());
        }

        System.out.println();
        // 获取当前元素下的某个子元素
        Element p = root.element("people");
        System.out.println(p.getText());

        System.out.println();
        Element user = root.element("user"); // 多个user默认取第一个
        System.out.println(user.elementText("name"));

        // 获取当前元素的某个属性
        Attribute id = user.attribute("id");
        System.out.println(id.getName());
        System.out.println(id.getValue());

        // 遍历属性
        List <Attribute> attributes = user.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName() + " " + attribute.getValue());
        }

        // 获取全部的文本内容
        System.out.println();
        System.out.println(user.elementText("name"));
        System.out.println(user.elementText("sex"));
        System.out.println(user.elementText("address"));
        System.out.println(user.elementText("password"));
        System.out.println(user.elementText("data"));
        Element data1 = user.element("data1");
        System.out.println(data1.getText());
        System.out.println(data1.getTextTrim());

        System.out.println();
        System.out.println("3 写数据到xml");
        // 推荐直接把程序里的数据拼接成xml格式，然后通过io流写出去，不要通过dom4j来写
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
        sb.append("<user>\r\n");
        sb.append("    <name>张三</name>\r\n");
        sb.append("    <sex>男</sex>\r\n");
        sb.append("    <address>北京</address>\r\n");
        sb.append("    <password>123456</password>\r\n");
        sb.append("    <data> 3 &lt; 5 &amp;&amp; 6 &gt; 4 </data>\r\n");
        sb.append("    <data1> 3 < 5 && 6 > 4 </data1>\r\n");
        sb.append("</user>\r\n");

        try(
                BufferedWriter bw = new BufferedWriter(new FileWriter("1/src/com/wjrz/wjrz1/test1.xml"))
                ) {
            bw.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("4 xml文件约束");
        // 限制xml文件只能按照某种格式进行书写
        // 约束文档：专门用来限制xml书写格式的文档，比如：限制标签、属性应该怎么写

        // 约束文档分类：
        // 1. DTD约束文档 :可以约束xml编写 但不能约束数据类型
        // 2. Schema约束文档 ：可以约束xml编写 也可以约束数据类型





































    }
}
