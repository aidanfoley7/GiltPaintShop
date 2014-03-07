package GiltPaintShop;

/**
 * Created with IntelliJ IDEA.
 * User: aidanfoley7
 * Date: 06/03/2014
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */
public class Paint {

    private String paintCode;
    private String finish;
    private boolean cannotBeAltered;


    public Paint(String paintCode, String finish, boolean cannotBeAltered) {
        this.paintCode = paintCode;
        this.finish = finish;
        this.cannotBeAltered = cannotBeAltered;
    }

    public String getPaintCode() {
        return paintCode;
    }

    public void setPaintCode(String paintCode) {
        this.paintCode = paintCode;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public boolean isCannotBeAltered() {
        return cannotBeAltered;
    }

    public void setCannotBeAltered(boolean cannotBeAltered) {
        this.cannotBeAltered = cannotBeAltered;
    }

    @Override
    public String toString() {
        return "Paint{" +
                "paintCode='" + paintCode + '\'' +
                ", finish='" + finish + '\'' +
                ", cannotBeAltered=" + cannotBeAltered +
                '}';
    }
}
