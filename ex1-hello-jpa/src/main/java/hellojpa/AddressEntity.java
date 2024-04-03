package hellojpa;

import javax.persistence.*;

@Entity
@Table(name="ADDRESS")
public class AddressEntity {
    @Id @GeneratedValue
    private Long id;

    private Address address;

    public AddressEntity(String old1, String street, String number) {
    }
}
