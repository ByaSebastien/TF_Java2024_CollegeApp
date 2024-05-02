package be.bstorm.tf_java2024_collegeapp.api.controllers;

import be.bstorm.tf_java2024_collegeapp.api.forms.CourseForm;
import be.bstorm.tf_java2024_collegeapp.bll.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody @Valid CourseForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Just an exemple
            return ResponseEntity.badRequest().build();
        }
        Long id = courseService.add(form.toEntity());
        return ResponseEntity.noContent().build();
    }
}
