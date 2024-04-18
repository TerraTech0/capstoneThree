package com.example.capstonethree.Controller;

import com.example.capstonethree.ApiResponse.APIResponse;
import com.example.capstonethree.DTO.DocumentDTO;
import com.example.capstonethree.Service.DocumentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/document")
public class DocumentController {
    private final DocumentService documentationService;
//    Logger logger= LoggerFactory.getLogger(DocumentController.class);

    @GetMapping("/get")
    public ResponseEntity getAllDocument(){
        return ResponseEntity.status(200).body(documentationService.getAllDocuments());
    }


    @PostMapping("/add")
    public ResponseEntity addDocument(@RequestBody @Valid DocumentDTO documentDTO){
        documentationService.addDocument(documentDTO);
        return ResponseEntity.status(200).body(new APIResponse("Document added"));
    }

    @PutMapping("/update")
    public ResponseEntity updateDocument(@RequestBody @Valid DocumentDTO documentDTO){
        documentationService.updateDocument(documentDTO);
        return ResponseEntity.status(200).body(new APIResponse("Document updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDocument(@PathVariable Integer id){
        documentationService.deleteDocument(id);
        return ResponseEntity.status(200).body(new APIResponse("Document deleted"));

    }


    @PostMapping("/upload-document/{documentDTO}/{clientId}/{lawyerId}")
    public ResponseEntity clientUploadDocument(@PathVariable DocumentDTO documentDTO,
                                               @PathVariable Integer clientId,
                                               @PathVariable Integer lawyerId){
        documentationService.clientUploadDocument(documentDTO, clientId, lawyerId);
        return ResponseEntity.ok().body("document uploaded successfully!");
    }
}
