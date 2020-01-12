package com.example.yut;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {

    public static void main(String[] args) {
        try {
            System.out.println("wewe");
            DocumentBuilderFactory dbf =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputStream is = Test.class.getResourceAsStream("student_infor.xml"); ///src/test/java/student_infor.xml
            Document document = db.parse(is);                 //这几行代码就像巫师的咒语，虽然读不懂，但是效果巨大（产生document）

            NodeList studentList = document.getElementsByTagName("student");
            for(int i = 0; i < studentList.getLength(); i++) {
                Element student = (Element) studentList.item(i);
                String id = student.getAttribute("id");
                String name = student.getAttribute("name");
                String sex = student.getAttribute("sex");
                String birth = student.getAttribute("birth");

                System.out.println("id:" + id);
                System.out.println("name:" + name);
                System.out.println("sex:" + sex);
                System.out.println("birth:[" + birth + "]");

                NodeList hobbies = student.getElementsByTagName("hobby");
                for(int j = 0; j < hobbies.getLength(); j++) {
                    Element hobby = (Element) hobbies.item(j);
                    String hobbyName = hobby.getTextContent();
                    System.out.println("\t" + hobbyName);
                }
                Element introduce =(Element) student.getElementsByTagName("introduce").item(0);
                System.out.println("简介\n\t" + introduce.getTextContent().trim());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}