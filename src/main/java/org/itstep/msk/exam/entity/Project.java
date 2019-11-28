package org.itstep.msk.exam.entity;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
}
