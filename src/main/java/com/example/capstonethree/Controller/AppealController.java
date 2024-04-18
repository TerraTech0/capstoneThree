
package com.example.capstonethree.Controller;

import com.example.capstonethree.ApiResponse.APIResponse;
import com.example.capstonethree.Model.Appeal;
import com.example.capstonethree.Service.AppealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor@RestController@RequestMapping("api/v1/appeal")
public class AppealController {

    Logger logger =LoggerFactory.getLogger(AppealController.class);
    private final AppealService appealService;
    @GetMapping("/get-all")
    public ResponseEntity getAll(){

        logger.info("inside get-all");
        return ResponseEntity.status(HttpStatus.OK).body(appealService.getall());
    }
    //    @PostMapping("/add")
//    public ResponseEntity add(@RequestBody @Valid AppealDTO appeal){
//        logger.info("inside add");
//
//        appealService.AppeaThecase(appeal);
//        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Appeal is added successfully"));
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody@Valid Appeal appeal, @PathVariable Integer id){
        logger.info("inside update");

        appealService.upDateAppeal(appeal,id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Appeal is updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        logger.info("inside delete");

        appealService.deleteAppeal(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Appeal is deleted successfully"));
    }
    //20

    @PutMapping("close-appeal/{caseId}/{userId}")
    public ResponseEntity closedAppeal(@PathVariable Integer caseId,@PathVariable Integer userId){
        appealService.closedAppeal(caseId,userId);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Closed successfully"));
    }
    //19
    @PutMapping("close-appeal/{caseId}/{userId}/{result}")
    public ResponseEntity approve(@PathVariable Integer caseId,@PathVariable Integer userId,@PathVariable String result){
        appealService.approve(caseId,userId,result);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("approved successfully"));
    }
}

