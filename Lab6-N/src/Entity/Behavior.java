package Entity;

import java.time.LocalDate;

public class Behavior {

    private int productId;
    private int click;
    private int addToCard;
    private int checkOut;
    private LocalDate datetime;

    public Behavior() {;}
    public Behavior( int productId, int click, int addToCard, int checkOut, LocalDate datetime) {
        this.productId = productId;
        this.click = click;
        this.addToCard = addToCard;
        this.checkOut = checkOut;
        this.datetime = datetime;
    }



    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getClick() {
        return click;
    }

    public void setCkick(int ckick) {
        this.click = ckick;
    }

    public int getAddToCard() {
        return addToCard;
    }

    public void setAddToCard(int addToCard) {
        this.addToCard = addToCard;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    public String toString(String separator) {
        StringBuilder sb = new StringBuilder();
        sb.append(productId).append(separator)
                .append(click).append(separator)
                .append(addToCard).append(separator)
                .append(checkOut).append(separator)
                .append(datetime);
        return sb.toString();
    }
}