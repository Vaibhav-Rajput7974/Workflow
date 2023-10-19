package com.workflow.controller;


import com.workflow.entity.Stage;
import com.workflow.repository.StageRepo;
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
    private StageRepo stageRepo;

    @GetMapping
    public ResponseEntity<List<Stage>> getAllStages() {
        List<Stage> stages = stageRepo.findAll();
        return ResponseEntity.ok(stages);
    }

    @GetMapping("/{stageId}")
    public ResponseEntity<Stage> getStageById(@PathVariable long stageId) {
        Optional<Stage> optionalStage = stageRepo.findById(stageId);

        if (optionalStage.isPresent()) {
            Stage stage = optionalStage.get();
            return ResponseEntity.ok(stage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Stage> addStage(@RequestBody Stage stage) {
        Stage savedStage = stageRepo.save(stage);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStage);
    }

    @PutMapping("/{stageId}")
    public ResponseEntity<Stage> updateStageById(@PathVariable long stageId, @RequestBody Stage updateStage) {
        Optional<Stage> optionalStage = stageRepo.findById(stageId);

        if (optionalStage.isPresent()) {
            Stage existingStage = optionalStage.get();
            existingStage.setStageName(updateStage.getStageName());
            existingStage.setStageDescription(updateStage.getStageDescription());
            stageRepo.save(existingStage);
            return ResponseEntity.ok(existingStage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{stageId}")
    public ResponseEntity<Void> deleteStageById(@PathVariable long stageId) {
        if (stageRepo.existsById(stageId)) {
            stageRepo.deleteById(stageId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
