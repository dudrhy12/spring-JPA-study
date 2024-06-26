package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("B")
@Getter @Setter
public class Book extends Item {
    private String author;
    private String isbn;
}