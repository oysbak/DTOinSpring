package org.hyperskill.learning;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class UserDB {
    @Getter
    @Id
    private int id;
    @Getter
    private String name;
    @Getter
    private String email;
    @Setter
    private LocalDate accountCreatedAt;

    public UserDB() {
    }

    public UserDB(int id, String name, String email, LocalDate accountCreatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accountCreatedAt = accountCreatedAt;
    }

    @Override
    public String toString() {
        return "UserDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", accountCreatedAt=" + accountCreatedAt +
                '}';
    }
}