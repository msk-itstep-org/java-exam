package org.itstep.msk.exam.repository;

import org.itstep.msk.exam.entity.Issue;
import org.itstep.msk.exam.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
    Set<Issue> findAllByProject(Project project);
}
