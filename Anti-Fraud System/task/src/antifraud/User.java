package antifraud;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    @NotNull
    private String username;
    @Column
    @NotNull
    private String password;
    @Column
    private String role;
    @Column
    @NotNull
    private String name;
    @Column(columnDefinition = "boolean default true")
    private boolean active = true;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}