package dev.codenation.errorcentral.endpoints;

import dev.codenation.errorcentral.entity.User;
import dev.codenation.errorcentral.exceptions.ResourceNotFoundException;
import dev.codenation.errorcentral.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("v1/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User")));
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> findById(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User")));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.userService.deleteById(id);
    }
}
