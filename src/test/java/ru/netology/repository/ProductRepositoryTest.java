package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);
    private ProductManager manager2 = new ProductManager();

    Product book1 = new Book(1, "title1", 100, "Author1");
    Product book2 = new Book(2, "title2", 900, "Author1");
    Product smartphone1 = new Smartphone(5, "title5", 1500, "USA");
    Product smartphone2 = new Smartphone(6, "title6", 1500, "Russia");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    void shouldRemoveByIdIfProductWithIdExist() {
        repo.removeById(5);
        Product[] expected = new Product[]{book1, book2, smartphone2};
        Product[] actually = repo.findAll();
        assertArrayEquals(expected, actually);
    }

    @Test
    void shouldThrowElementNotFound() {
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(17);
        });
    }

}