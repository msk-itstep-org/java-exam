package org.itstep.msk.exam.entity;


import javax.persistence.*;

@Entity
@Table(name = "proj")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "projname",nullable = false)
    private String name;

    public Project() {
    }

    public Integer getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
