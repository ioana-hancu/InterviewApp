package interviewapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstname;
    private String lastname;
    private int age;

    protected Candidate(){}

    public Candidate(long id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}
