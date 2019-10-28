package org.mentor.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", unique = false)
    private String role;

    public Role() {
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String name) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    } //Long
}
