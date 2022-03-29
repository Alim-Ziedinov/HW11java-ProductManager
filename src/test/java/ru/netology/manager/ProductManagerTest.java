package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager();

    Product book1 = new Book(1, "title1", 100, "Author1");
    Product book2 = new Book(2, "title2", 900, "Author1");
    Product book3 = new Book(3, "title3", 1000, "Author3");
    Product book4 = new Book(4, "title2", 1000, "Author4");
    Product smartphone1 = new Smartphone(5, "title5", 1500, "USA");
    Product smartphone2 = new Smartphone(6, "title6", 1500, "Russia");
    Product smartphone3 = new Smartphone(7, "title6", 1500, "USA");
    Product smartphone4 = new Smartphone(8, "title8", 1500, "China");

    @BeforeEach
    public void addData() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
    }

    @Test
    void shouldSearchByIfNoBookWithTitle() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("title15");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfBookWithTitleExist() {
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("title1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfNoBookWithAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Author50");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookWithAuthor() {
        Product[] expected = new Product[]{book4};
        Product[] actual = manager.searchBy("Author4");
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByIfNoSmartphoneWithManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Germany");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfSmartphoneWithManufacturerExist() {
        Product[] expected = new Product[]{smartphone2};
        Product[] actual = manager.searchBy("Russia");
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByIfSmartphoneWithTitleExist2() {
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("title5");
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByIfSmartphonesWithManufacturerExist4() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("hit");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTheSameAuthor() {
        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Author1");
        assertArrayEquals(expected,actual);
    }

    @Test
    void  shouldFindTheSameManufacture() {
        Product[] expected = {smartphone1,smartphone3};
        Product[] actual = manager.searchBy("USA");
        assertArrayEquals(expected,actual);
    }
}