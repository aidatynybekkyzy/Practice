package practice.demoPractice.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class HelloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;
    private String status;
private LocalDateTime dateCreated;
    public HelloModel() {
    }

    public HelloModel(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public HelloModel(String message, String status, LocalDateTime dateCreated) {
        this.message = message;
        this.status = status;
        this.dateCreated = dateCreated.now();
    }

    public LocalDateTime getLocalDateTime() {
        return dateCreated;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.dateCreated = localDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
