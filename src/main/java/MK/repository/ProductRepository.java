package MK.repository;

import MK.model.Producer;
import MK.model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductRepository extends AbstractGenericRepository<Product> implements ProductInterface {

    public List<Product> importProductFromFile(String filename) {
        File file = new File(filename);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Product> products = new ArrayList<>();
        while (sc.hasNextLine()) {
            String data[] = sc.nextLine().split(",");
            Product product = Product.builder()
                    .name(data[0])
                    .price(new BigDecimal(data[1]))
                    .producerId(Integer.parseInt(data[2]))
                    .build();
            products.add(product);
        }
        return products;
    }

    public void enterDataProductToDataBase() {
        List<Product> products = importProductFromFile("C:/Users/Karol/IdeaProjects/testowanie_projekt2/src/main/java/resources/products.txt");
        for (int i = 0; i < products.size(); i++) {
            saveOrUpdate(products.get(i));
        }
    }

}
