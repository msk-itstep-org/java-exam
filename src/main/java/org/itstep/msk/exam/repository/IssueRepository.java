package org.itstep.msk.exam.repository;

import org.itstep.msk.exam.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Integer> {

    @Query(value = "select * from issues where project=?",nativeQuery = true)
    Set<Issue> findIssuesByProject(Integer idProject);
}
