package com.workflow.controller;


import com.workflow.entity.Stage;
import com.workflow.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping
    public ResponseEntity<List<Stage>> getAllStages() {
        List<Stage> stages = stageService.getAllStages();
        return ResponseEntity.ok(stages);
    }

    @GetMapping("/" +
            "{stageId}")
    public ResponseEntity<Stage> getStageById(@PathVariable long stageId) {
        Optional<Stage> optionalStage = stageService.getStageById(stageId);

        if (optionalStage.isPresent()) {
            Stage stage = optionalStage.get();
            return ResponseEntity.ok(stage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{projectId}")
    public ResponseEntity<Stage> addNewStage(@PathVariable long projectId , @RequestBody Stage addStage) {
        Stage savedStage = stageService.addNewStage(projectId , addStage);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStage);
    }

    @PutMapping("/{stageId}")
    public ResponseEntity<Stage> updateStageById(@PathVariable long stageId, @RequestBody Stage updateStage) {
        Optional<Stage> optionalStage = stageService.updateStage(stageId, updateStage);

        if (optionalStage.isPresent()) {
            return ResponseEntity.ok(optionalStage.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{stageId}")
    public ResponseEntity<Void> deleteStageById(@PathVariable long stageId) {
        if (stageService.deleteStageById(stageId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
