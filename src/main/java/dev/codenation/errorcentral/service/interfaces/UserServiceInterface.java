package dev.codenation.errorcentral.service.interfaces;

import dev.codenation.errorcentral.dto.UserDTO;
import dev.codenation.errorcentral.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserServiceInterface extends ServiceInterface<User> {

    User save(User user);

    Page<UserDTO> findAll(Pageable pageable);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    void deleteById(Long id);
}
