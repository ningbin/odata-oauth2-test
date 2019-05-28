package io.github.ningbin.odata;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import io.github.ningbin.odata.model.jpa.Customer;
import io.github.ningbin.odata.model.jpa.Description;
import io.github.ningbin.odata.model.jpa.Product;

@Component
@ConditionalOnProperty(name = "init-data", matchIfMissing = true)
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
	Customer customer = new Customer("C1");
	customer.setName("Customer 1");
	Product product1 = new Product("P1");
	product1.setDescription(new Description("Product 1", "ABC"));
	customer.addProduct(product1);
	Product product2 = new Product("P2");
	product2.setDescription(new Description("Product 2", "XYZ"));
	customer.addProduct(product2);
	entityManager.persist(customer);
	
	Customer customer2 = new Customer("中国顾客1");
	customer2.setName("中国顾客 1");
	Product product21 = new Product("中国产品 1");
	product21.setDescription(new Description("中国产品 1", "中国厂家1"));
	customer2.addProduct(product21);
	Product product22 = new Product("中国产品 2");
	product22.setDescription(new Description("中国产品 2", "中国厂家2"));
	customer2.addProduct(product22);
	entityManager.persist(customer2);
	
	Customer customer3 = new Customer("日本人の顧客2");
	customer3.setName("日本人の顧客 2");
	Product product31 = new Product("日本製品1");
	product31.setDescription(new Description("日本製品 1", "日本メーカー1"));
	customer3.addProduct(product31);
	Product product32 = new Product("日本製品2");
	product32.setDescription(new Description("日本製品 2", "日本メーカー2"));
	customer3.addProduct(product32);
	entityManager.persist(customer3);
	
	Customer customer4 = new Customer("한국 고객2");
	customer4.setName("한국 고객 2");
	Product product41 = new Product("한국산 제품1");
	product41.setDescription(new Description("한국산 제품 1", "한국 메이커1"));
	customer4.addProduct(product31);
	Product product42 = new Product("한국산 제품2");
	product42.setDescription(new Description("한국산 제품 2", "한국 메이커2"));
	customer4.addProduct(product42);
	entityManager.persist(customer4);
    }

}
