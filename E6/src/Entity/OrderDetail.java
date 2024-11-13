package Entity;

public class OrderDetail {
    private int id;
    private Order order;
    private Product product;
    private int quantity;
    private double price;

    public OrderDetail() {}

    public OrderDetail(int id, Order order, Product product, int quantity) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice() * quantity;
    }

    public int getId() {
        return id;
    }

    public String setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String toString(String separator) {
        StringBuilder stb = new StringBuilder();
        stb.append(id).append(separator)
                .append(order).append(separator)
                .append(product).append(separator)
                .append(quantity).append(separator)
                .append(price);
        return stb.toString();
    }
}
