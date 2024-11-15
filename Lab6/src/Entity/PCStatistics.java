package Entity;

import java.time.LocalDate;

public class PCStatistics {
    private int id;
    private double percentView;
    private double percentAddToCard;
    private double percentCheckOut;
    private LocalDate datetime;

    public PCStatistics() {;}
    public PCStatistics(int id, double percentView, double percentAddToCard, double percentCheckOut, LocalDate datetime) {
        this.id = id;
        this.percentView = percentView;
        this.percentAddToCard = percentAddToCard;
        this.percentCheckOut = percentCheckOut;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPercentView() {
        return percentView;
    }

    public void setPercentView(double percentView) {
        this.percentView = percentView;
    }

    public double getPercentAddToCard() {
        return percentAddToCard;
    }

    public void setPercentAddToCard(double percentAddToCard) {
        this.percentAddToCard = percentAddToCard;
    }

    public double getPercentCheckOut() {
        return percentCheckOut;
    }

    public void setPercentCheckOut(double percentCheckOut) {
        this.percentCheckOut = percentCheckOut;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "PCStatistics{" +
                "id=" + id +
                ", percentView=" + percentView +
                ", percentAddToCard=" + percentAddToCard +
                ", percentCheckOut=" + percentCheckOut +
                ", datetime=" + datetime +
                '}';
    }
}
