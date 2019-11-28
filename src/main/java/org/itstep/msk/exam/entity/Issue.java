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
    @JoinTable(name="users",joinColumns = {@JoinColumn(name = "id",referencedColumnName = "reporter_id")})
    private Set<User> assignee;

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public Set<User> getAssignee() {
        return assignee;
    }

    public void setAssignee(Set<User> assignee) {
        this.assignee = assignee;
    }
}
