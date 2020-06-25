package dev.codenation.errorcentral.endpoints;

import dev.codenation.errorcentral.dto.UserDTO;
import dev.codenation.errorcentral.entity.User;
import dev.codenation.errorcentral.exceptions.ResourceNotFoundException;
import dev.codenation.errorcentral.service.impl.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("v1/api/user")
public class UserController {

    private final UserService userService;

    @Operation(description = "Cria um novo usuário")
    @ApiResponse(description = "Success", responseCode = "201", content = @Content(mediaType = "application/json"))
    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.CREATED);
    }

    @Operation(description = "Lista um usuário por id")
    @ApiResponse(description = "Success", responseCode = "201", content = @Content(mediaType = "application/json"))
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User")));
    }

    @Operation(description = "Lista um usuário por email")
    @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json"))
    @GetMapping("/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User")));
    }

    @Operation(description = "Lista todos os usuários")
    @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json"))
    @GetMapping
    public Page<UserDTO> findAll(Pageable pageable){
        return this.userService.findAll(pageable);
    }

    @Operation(description = "Deleta um usuário por id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.userService.deleteById(id);
    }
}
