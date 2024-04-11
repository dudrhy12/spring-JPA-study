package jpabook.jpashop;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String username;
}
