package Controller;

import Entity.Product;
import Service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product quantity: ");
        int quantity = scanner.nextInt();
        System.out.println("Enter product price: ");
        double price = scanner.nextDouble();

        if (productService.isProductExist(name)) {
            System.out.println("Product already exists!");
            return;
        }

        if (quantity < 0){
            System.out.println("Ivalid quantity!");
            return;
        }

        if (price < 0){
            System.out.println("Ivalid price!");
            return;
        }

        Product newProduct = new Product(0, name, quantity, price);

    }
}
