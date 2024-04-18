package com.example.capstonethree.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@AllArgsConstructor
@Data
public class AppealDTO {
    @NotNull(message = "cant null caseID")
    private Integer case_Id;
    @NotEmpty(message = "title appeal can not be null")
    private String title;
    @NotEmpty(message = "description appeal can not be null")
    private String description;
    private LocalDate startDate;

}
