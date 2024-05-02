package be.bstorm.tf_java2024_collegeapp.api.controllers.security;

import be.bstorm.tf_java2024_collegeapp.api.UserTokenDTO;
import be.bstorm.tf_java2024_collegeapp.api.forms.LoginForm;
import be.bstorm.tf_java2024_collegeapp.bll.services.UserService;
import be.bstorm.tf_java2024_collegeapp.domain.entities.User;
import be.bstorm.tf_java2024_collegeapp.il.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<UserTokenDTO> login(@RequestBody LoginForm form){
        User user = userService.login(form.email(), form.password());
        UserTokenDTO dto = UserTokenDTO.fromEntity(user);
        String token = jwtUtils.generateToken(user);
        dto.setToken(token);
        return ResponseEntity.ok(dto);
    }
}
