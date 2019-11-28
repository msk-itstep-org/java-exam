package org.itstep.msk.exam.controller;

import org.itstep.msk.exam.entity.Project;
import org.itstep.msk.exam.entity.User;
import org.itstep.msk.exam.repository.IssueRepository;
import org.itstep.msk.exam.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IssueRepository issueRepository;

    @GetMapping("/")
    public String projects(Model model) {
        model.addAttribute("projects", projectRepository.findAll());

        return "projects";
    }

    @GetMapping("/issues/{projectId}")
    public String issues(@PathVariable Integer projectId, Model model) {
        Project project = projectRepository.getOne(projectId);
        model.addAttribute("project", project);
        model.addAttribute("issues", issueRepository.findAllByProject(project));

        return "issues";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }
}
