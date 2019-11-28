package org.itstep.msk.exam.controller;

import org.itstep.msk.exam.entity.Issue;
import org.itstep.msk.exam.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IssuesController {
    @Autowired
    IssueRepository issueRepository;

    @GetMapping("/issues")
    @ResponseBody
    public List<Issue> list(Principal principal) {
    return issueRepository.findById();
    }
}
