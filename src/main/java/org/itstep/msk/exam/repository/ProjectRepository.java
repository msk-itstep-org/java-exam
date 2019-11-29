package org.itstep.msk.exam.repository;

import org.itstep.msk.exam.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
