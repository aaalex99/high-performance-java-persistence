package com.vladmihalcea.book.hpjp.hibernate.equality;

import com.vladmihalcea.book.hpjp.hibernate.identifier.Identifiable;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vlad Mihalcea
 */
public class DefaultEqualityTest extends AbstractEqualityCheckTest {

    @Override
    protected Class<?>[] entities() {
        return new Class[]{
            Book.class
        };
    }

    @Test
    public void testEquality() {
        Book book = new Book();
        book.setTitle("High-PerformanceJava Persistence");

        assertEqualityConstraints(Book.class, book);
    }

    @Entity(name = "Book")
    @Table(name = "book")
    public static class Book implements Identifiable<Long> {

        @Id
        @GeneratedValue
        private Long id;

        private String title;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
