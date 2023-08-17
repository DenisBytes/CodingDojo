package modelspart2;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="licenses")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Date expirationDate;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    public License() {

    }

    // ...
    // getters and setters removed for brevity
    // ...
}
