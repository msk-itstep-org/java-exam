package org.itstep.msk.exam.entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="issue")
public class Issue {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;

    @Column(name = "project_id")
    private Project project;

    @Column(name = "reporter_id")
    private User reporter;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name="user",joinColumns = {@JoinColumn(name = "id",referencedColumnName = "assignee")},
    inverseJoinColumns = {@JoinColumn(name = "assignee",referencedColumnName = "id")})
    private Set<User> assignee;
}
