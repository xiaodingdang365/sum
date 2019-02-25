package dom;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

public class UseDom4j {

    @Test
    public void test1() throws DocumentException {
        Document document = read("D:\\multi\\sum\\src\\main\\resources\\frRelation.xml");
        Element rootElement = document.getRootElement();
        /*Iterator iterator = rootElement.elementIterator();
        for (;iterator.hasNext();
             ) {
            Element next = (Element) iterator.next();
            System.out.println(next.attribute("name"));
        }*/

       /* for (Iterator i = rootElement.elementIterator("a");i.hasNext();){
            Element next = (Element) i.next();
            System.out.println(next.getName());
        }*/

       /*for (Iterator i = rootElement.attributeIterator();i.hasNext();){
           Attribute next = (Attribute) i.next();
           System.out.println(next.getValue());
       }*/
        rootElement.accept(new MyVisitor());

    }

    @Test
    public void test2() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:\\multi\\sum\\src\\main\\resources\\frRelation.xml"));
        Element rootElement = document.getRootElement();
        List<Node> list = rootElement.selectNodes("*[name()='frameRelationType']");
        for (Node node: list
             ) {
            System.out.println(node.getPath());
        }

    }

    @Test
    public void test3() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:\\multi\\sum\\src\\main\\resources\\frRelation.xml"));
        Element rootElement = document.getRootElement();
        String xml = document.asXML();
        //System.out.println(xml);
        String text = "<James/>";
        Document document1 = DocumentHelper.parseText(text);
        System.out.println(document1.asXML());

    }

    @Test
    public void test4() throws DocumentException, IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("Root");
        Element element1 = root.addElement("test").addAttribute("name", "张三").addAttribute("age", "30").addText("你好,世界");
        Element element2 = root.addElement("test5").addText("wj");
        FileWriter writer = new FileWriter("foo.xml");
        document.write(writer);
        writer.flush();
        writer.close();


    }
    public static Document read(String fileName) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(fileName));
        return document;
    }
}
