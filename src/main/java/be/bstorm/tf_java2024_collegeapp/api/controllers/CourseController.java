package be.bstorm.tf_java2024_collegeapp.api.controllers;

import be.bstorm.tf_java2024_collegeapp.api.forms.AddFavoriteForm;
import be.bstorm.tf_java2024_collegeapp.api.forms.CourseForm;
import be.bstorm.tf_java2024_collegeapp.bll.services.CourseService;
import be.bstorm.tf_java2024_collegeapp.domain.entities.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {

    private final CourseService courseService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody @Valid CourseForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Just an exemple
            return ResponseEntity.badRequest().build();
        }
        Long id = courseService.add(form.toEntity());
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('STUDENT')")
    @PostMapping("/favorite")
    public ResponseEntity<Void> addFavorite(
            Authentication authentication,
            @RequestBody @Valid AddFavoriteForm form
    ){
        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok().build();
    }
}
