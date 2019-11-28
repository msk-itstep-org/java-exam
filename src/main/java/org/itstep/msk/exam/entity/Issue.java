package org.itstep.msk.exam.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName = "id")
    private Project project;

    @NotNull
    @ManyToOne
    @JoinColumn(name="user_reporter_id", referencedColumnName = "id")
    private User reporter;

    @NotNull
    @ManyToOne
    @JoinColumn(name="user_assignee_id", referencedColumnName = "id")
    private User assignee;

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

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }
}
