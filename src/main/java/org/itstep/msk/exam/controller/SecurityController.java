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
public class SecurityController {
    @Autowired
    IssueRepository issueRepository;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/")
    public String getProjects(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return "projects";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/issues")
    public String getIssues(Model model) {
        model.addAttribute("issues", issueRepository.findAll());
        return "issues";
    }

    @GetMapping("/issues/{id}")
    public String getIssues(@PathVariable Integer id, Model model) {
        model.addAttribute("issues", issueRepository.findAllByProject(projectRepository.findById(id).orElse(new Project())));
        return "issues";
    }
}
