package dom;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;

public class MyVisitor extends VisitorSupport {

    @Override
    public void visit(Element node) {
        System.out.println(node.getName());
    }

    @Override
    public void visit(Attribute node) {
        System.out.println(node.getName());
    }
}
