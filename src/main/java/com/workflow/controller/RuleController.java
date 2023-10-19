package com.workflow.controller;


import com.workflow.repository.RuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private RuleRepo ruleRepo;


}
