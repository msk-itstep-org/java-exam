package org.itstep.msk.exam.entity;

import javax.persistence.*;

@Entity
@Table(name="issues")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    private String name;
    private String description;
    private Project project;
    private User reporter;
    private User assignee;
}
