package org.itstep.msk.exam.entity;

import javax.persistence.*;

@Entity
@Table(name = "issues")
public class Issue {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @OneToOne (targetEntity = Project.class)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "reporter_user_id", referencedColumnName = "id")
    private User reporter;
    @OneToOne (targetEntity = User.class)
    @JoinColumn(name = "assignee_user_id", referencedColumnName = "id")
    private User assignee;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Project getProject() {
        return project;
    }

    public User getReporter() {
        return reporter;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }
}
