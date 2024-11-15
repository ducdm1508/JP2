package Entity;

import java.util.Objects;
import java.util.StringJoiner;

public class CRStatistics {
    private int id;
    private int month;
    private int year;
    private int totalView;
    private int totalAddToCard;
    private int totalCheckOut;

    public CRStatistics(){;}

    public CRStatistics(int month, int year, int id) {
        this.month = month;
        this.year = year;
        this.id = id;
    }

    public CRStatistics(int id, int month, int year, int totalView, int totalAddToCard, int totalCheckOut) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.totalView = totalView;
        this.totalAddToCard = totalAddToCard;
        this.totalCheckOut = totalCheckOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotalView() {
        return totalView;
    }

    public void setTotalView(int totalView) {
        this.totalView = totalView;
    }

    public int getTotalAddToCard() {
        return totalAddToCard;
    }

    public void setTotalAddToCard(int totalAddToCard) {
        this.totalAddToCard = totalAddToCard;
    }

    public int getTotalCheckOut() {
        return totalCheckOut;
    }

    public void setTotalCheckOut(int totalCheckOut) {
        this.totalCheckOut = totalCheckOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CRStatistics that = (CRStatistics) o;
        return id == that.id && month == that.month && year == that.year && totalView == that.totalView && totalAddToCard == that.totalAddToCard && totalCheckOut == that.totalCheckOut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month, year, totalView, totalAddToCard, totalCheckOut);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CRStatistics.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("month=" + month)
                .add("year=" + year)
                .add("totalView=" + totalView)
                .add("totalAddToCard=" + totalAddToCard)
                .add("totalCheckOut=" + totalCheckOut)
                .toString();
    }
}