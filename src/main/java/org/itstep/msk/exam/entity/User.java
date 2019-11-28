package org.itstep.msk.exam.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "user_roles",joinColumns = {@JoinColumn(name="user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private Set<Role> roles;
}
