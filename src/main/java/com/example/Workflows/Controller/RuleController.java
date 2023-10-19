//package com.example.Workflows.Controller;
//
//import com.example.Workflows.Entity.Rule;
//import com.example.Workflows.Entity.Stage;
//import com.example.Workflows.Entity.Ticket;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import org.springframework.web.bind.annotation.*;
//
//@RequestMapping("/projects")
//@RestController
//public class RuleController {
//    @PostMapping("/{projectID}/stages/{stageID}/rules")
//    public Rule addRule(@RequestBody Rule rule, @PathVariable Long projectID, @PathVariable Long stageID){
//        return new Rule();
//    }
//
//    @GetMapping("/{projectID}/stages/{stageID}/rules")
//    public Rule getAllRules(@RequestBody Rule rule, @PathVariable Long projectID,@PathVariable Long stageID){
//        return new Rule();
//    }
//
//    @GetMapping("/{projectID}/stages/{stageID}/rules/{ruleID}")
//    public Rule getRuleById(@RequestBody Rule rule, @PathVariable Long projectID,@PathVariable Long stageID,@PathVariable Long ruleID){
//        return new Rule();
//    }
//
//    @PutMapping("/{projectID}/stages/{stageID}/rules")
//    public Rule updateRuleById(@RequestBody Rule rule, @PathVariable Long projectID,@PathVariable Long stageID){
//        return new Rule();
//    }
//
//    @DeleteMapping("/{projectID}/stages/{stageID}/rules/{ruleID}")
//    public void deleteRuleById(@PathVariable Long projectID,@PathVariable Long stageID,@PathVariable Long ruleID){
//        return;
//    }
//
//    @PostMapping("/{projectID}/stages/{stageID}/rules/{ruleID}/triggers")
//    public String addTrigger(@RequestBody Rule rule, @PathVariable Long projectID, @PathVariable Long stageID,@PathVariable Long ruleID){
//        return new String();
//    }
//
//    @PostMapping("/{projectID}/stages/{stageID}/rules/{ruleID}/actions")
//    public String addAction(@RequestBody Rule rule, @PathVariable Long projectID, @PathVariable Long stageID,@PathVariable Long ruleID){
//        return new String();
//    }
//
//    @DeleteMapping("/{projectID}/stages/{stageID}/rules/{ruleID}/triggers/{triggerID}")
//    public void deleteTrigger(@PathVariable Long projectID,@PathVariable Long stageID,@PathVariable Long ruleID,@PathVariable Long triggerID){
//        return;
//    }
//    @DeleteMapping("/{projectID}/stages/{stageID}/rules/{ruleID}/actions/{actionID}")
//    public void deleteAction(@PathVariable Long projectID,@PathVariable Long stageID,@PathVariable Long ruleID,@PathVariable Long actionID){
//        return;
//    }
//
//}
