package com.kodilla.hibernate.invoiceDao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import com.kodilla.hibernate.invoice.dao.ItemDao;
import com.kodilla.hibernate.invoice.dao.ProductDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
        Product product = new Product("product1");
        Product product2 = new Product("product2");
        Product product3 = new Product("product3");

        productDao.save(product);
        productDao.save(product2);
        productDao.save(product3);

        Item item = new Item(product,new BigDecimal(115),5,(new BigDecimal(100)));
        Item item2 = new Item(product2,new BigDecimal(120),1,(new BigDecimal(90)));
        Item item3 = new Item(product3,new BigDecimal(150),3,(new BigDecimal(50)));

        Invoice invoice = new Invoice("1234");
        invoice.getItems().add(item);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0,invoice.getId());

        //CleanUp
        itemDao.deleteById(item.getId());
    }
}
