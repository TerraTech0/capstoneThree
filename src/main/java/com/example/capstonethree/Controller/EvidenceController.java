package com.example.capstonethree.Controller;


import com.example.capstonethree.ApiResponse.APIResponse;
import com.example.capstonethree.Model.Evidence;
import com.example.capstonethree.Service.EvidenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController@RequestMapping("api/v1/evidence")
public class EvidenceController {

    Logger logger = LoggerFactory.getLogger(EvidenceController.class);
    private final EvidenceService evidenceService;

    @GetMapping("/get-all")
    public ResponseEntity getAll(){

        logger.info("inside get-all");
        return ResponseEntity.status(HttpStatus.OK).body(evidenceService.getAll());
    }
    @PostMapping("/add/{appealId}")
    public ResponseEntity add(@PathVariable Integer appealId, @RequestBody @Valid Evidence evidence){
        logger.info("inside add");

        evidenceService.add(appealId,evidence);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("evidence appeal is added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody@Valid Evidence evidence ,@PathVariable Integer id){
        logger.info("inside update");

        evidenceService.update(evidence,id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("evidence is updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        logger.info("inside delete");

        evidenceService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("evidence is deleted successfully"));
    }

    //21
    @GetMapping("/get-all-evidence/{appealId}")
    public ResponseEntity getAllevidenceByAppeal(@PathVariable Integer appealId){
        return ResponseEntity.status(HttpStatus.OK).body(evidenceService.getAllevidenceByAppeal(appealId));
    }



}
