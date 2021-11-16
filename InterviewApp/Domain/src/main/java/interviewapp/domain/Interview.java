package interviewapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String candidate;
    private int date;
    private int time;

    protected Interview(){}

    public Interview(long id, String candidate, int date, int time) {
        this.id = id;
        this.candidate = candidate;
        this.date = date;
        this.time = time;

    }

    public long getId() {
        return id;
    }

    public String getCandidate() {
        return candidate;
    }

    public int getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }
}
