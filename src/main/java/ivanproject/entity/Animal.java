package ivanproject.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @Column(name = "type")
    private String type;

    public void setId(Long id) {
        this.id = id;
    }


}

