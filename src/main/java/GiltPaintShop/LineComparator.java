package GiltPaintShop;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: aidanfoley7
 * Date: 07/03/2014
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class LineComparator implements Comparator<String> {
	
	@Override
    public int compare(String x, String y) {
        if (x == null)
            return y==null ? 0 : -1;
        else if (y == null)
            return +1;
        else {
            int lengthX = x.length();
            int lengthY = y.length();
            if (lengthX == lengthY)
                return x.compareTo(y); //break ties?
            else
                return lengthX < lengthY ? -1 : +1;
        }
    }
}
