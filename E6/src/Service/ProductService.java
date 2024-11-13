package Service;

import Entity.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getProductsByName(String name) {
        return products.stream()
                .filter(product -> product.getName().contains(name))
                .collect(Collectors.toList());
    }


    public boolean isProductExist(String name) {
        return products.stream().anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }


    public void readFile() throws IOException {
        String sysPath = System.getProperty("user.dir");
        String fileInPath = sysPath + "\\Data\\products.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileInPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.isEmpty()) {
                    String[] productData = line.split(",");
                    int id = Integer.parseInt(productData[0]);
                    String name = productData[1];
                    int quantyti = Integer.parseInt(productData[2]);
                    double price = Double.parseDouble(productData[3]);
                    Product product = new Product(id, name, quantyti, price);
                    products.add(product);
                }
            }
        }
    }

    public void writeFile() throws IOException {
        String sysPath = System.getProperty("user.dir");
        String fileInPath = sysPath + "\\Data\\products.txt";
    }
}
