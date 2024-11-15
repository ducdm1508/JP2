import Entity.Customer;
import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        List<Order> orders = new ArrayList<Order>();
        List<Product> products = new ArrayList<Product>();
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        customers.add(new Customer(1, "Nguyen Van A"));

        products.add(new Product(1, "Iphone", 1000, 50));
        products.add(new Product(2, "Samsung", 500, 50));

        orders.add(new Order(1, customers.get(0), LocalDateTime.now()));
        orders.add(new Order(2, customers.get(0), LocalDateTime.now()));

        orderDetails.add(new OrderDetail(1, orders.get(0), products.get(1), 2, 0));
        orderDetails.add(new OrderDetail(2, orders.get(1), products.get(0), 3, 0));

        orderDetails.forEach(System.out::println);

        String fileOut = System.getProperty("user.dir").replace("/","\\") + "/data/ OrderCustomer.out.txt";
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut));
            orderDetails.stream()
                    .peek(orderDetail -> {
                        try{
                            String line2Write = orderDetail.toString();
                            bufferedWriter.write(line2Write);
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                        }catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }).collect(Collectors.toList());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}