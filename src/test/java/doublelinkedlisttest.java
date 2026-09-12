import Algorithm.doubleDirectionLinkedList;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.logging.XMLFormatter;

public class doublelinkedlisttest {

    @Test
    public void removeindex() throws IllegalAccessException {
        doubleDirectionLinkedList d=new doubleDirectionLinkedList();
        for (int i = 0; i < 10; i++) {
            d.addFirst(i);
        }
        for (int i:d) System.out.print(i+" ");





    }


}
