package hellojpa;

import javax.persistence.*;
@Entity
public class Book extends Item{
    private String author;
    private String isbn;
}
