package be.bstorm.tf_java2024_collegeapp.api.controllers;

import be.bstorm.tf_java2024_collegeapp.api.forms.GradeForm;
import be.bstorm.tf_java2024_collegeapp.bll.services.GradeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grade")
@CrossOrigin("*")
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody @Valid GradeForm form){
        gradeService.add(form.toEntity());
        return ResponseEntity.noContent().build();
    }

}
