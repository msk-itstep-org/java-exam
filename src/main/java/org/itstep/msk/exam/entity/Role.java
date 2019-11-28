package org.itstep.msk.exam.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String role;

    public Integer getId() {
        return id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
