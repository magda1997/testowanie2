package MK;

import MK.exceptions.MyException;
import MK.model.Customer;
import MK.model.Product;
import MK.repository.CustomerRepository;
import MK.repository.ProducerRepository;
import MK.repository.ProductRepository;
import MK.service.Operations;

import java.math.BigDecimal;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {

            CustomerRepository customerRepository = new CustomerRepository();
            ProductRepository productRepository = new ProductRepository();
            ProducerRepository producerRepository = new ProducerRepository();

            producerRepository.enterDataProducerToDataBase();
            productRepository.enterDataProductToDataBase();
            customerRepository.initialiseData();
            Operations operations = new Operations();
            operations.znajdzNajstarszegoKlienta();
            System.out.println("Average age=" + operations.calculateAverageAgeCustomers());
            operations.buyProduct();


        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
