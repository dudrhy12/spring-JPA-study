package hellojpa;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
}
