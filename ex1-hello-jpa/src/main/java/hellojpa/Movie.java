package hellojpa;

import javax.persistence.*;

@Entity
public class Movie extends Item{
    private String director;
    private String actor;
}
