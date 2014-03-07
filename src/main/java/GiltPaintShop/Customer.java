package GiltPaintShop;

import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: aidanfoley7
 * Date: 06/03/2014
 * Time: 21:12
 * To change this template use File | Settings | File Templates.
 */
public final class Customer{

    private int customerId;
    private Map<Integer, Paint> paints;
    private boolean isOrderApproved;


    public Customer(Map<Integer, Paint> paints, int customerId, boolean isOrderApproved) {
        this.paints = paints;
        this.customerId = customerId;
        this.isOrderApproved = isOrderApproved;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Map<Integer, Paint> getPaints() {
        return paints;
    }

    public void setPaints(Map<Integer, Paint> paints) {
        this.paints = paints;
    }

    public boolean onecolourOrdered() {
        return this.paints.size() == 1;
    }

    public boolean isOrderApproved() {
        return isOrderApproved;
    }

    public void setOrderApproved(boolean orderApproved) {
        isOrderApproved = orderApproved;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", paints=" + paints +
                ", isOrderApproved=" + isOrderApproved +
                '}';
    }
}
