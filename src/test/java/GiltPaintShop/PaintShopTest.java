package GiltPaintShop;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aidanfoley7
 * Date: 07/03/2014
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
public class PaintShopTest {
    @Test
    public void testCaseOne() throws Exception {
        List<String> orderOne = new ArrayList<String>();
        orderOne.add("5 M");
        orderOne.add("2 G 3 M 4 G");
        orderOne.add("1 M 3 G 5 G");

        PaintShop paintShop = new PaintShop();
        String response = paintShop.retrieveOrder(orderOne);
        assertEquals("G G G G M", response);

    }
}
