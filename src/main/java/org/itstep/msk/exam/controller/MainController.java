package org.itstep.msk.exam.controller;

import org.itstep.msk.exam.entity.Issue;
import org.itstep.msk.exam.repository.IssueRepository;
import org.itstep.msk.exam.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;


@Controller
public class MainController {

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/issueadd")
    public String saveIssue(Issue issue){
        issueRepository.save(issue);
        issueRepository.flush();
        return "redirect:/issues";
    }
    @GetMapping("/issueadd")
    public String addIssue(Model model, @ModelAttribute Issue issue){
        model.addAttribute("issue",issue);
        model.addAttribute("projects",projectRepository.findAll());
        return "/issueadd";
    }

    @GetMapping("/issues/{projectId}")
    public String issues(Model model, @PathVariable Integer projectId){
        Set<Issue> issues = issueRepository.findIssuesByProject(projectId);
        model.addAttribute("issues",issues);
        return "issue";
    }

    @GetMapping("projects")
    public String getProjects(Model model){
        model.addAttribute(projectRepository.findAll());
        return "projects";
    }
}
