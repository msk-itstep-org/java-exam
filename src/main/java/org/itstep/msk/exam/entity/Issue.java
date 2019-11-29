package org.itstep.msk.exam.entity;


import javax.persistence.*;

@Entity
@Table(name = "article")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "arcticlename")
    private String name;

    @Column(name = "descpiption")
    private String description;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "projname")
    private Project project;

    @Column(name = "reporter")
    private User reporter;

    @Column(name = "assignee")
    private User assignee;
}
