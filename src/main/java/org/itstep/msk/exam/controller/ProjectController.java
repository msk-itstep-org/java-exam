package org.itstep.msk.exam.controller;

import org.itstep.msk.exam.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @GetMapping("/projects")
    public String getProj(Model model) {
        model.addAttribute("project", new Project());
        return "projects";
    }
}
