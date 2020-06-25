package dev.codenation.errorcentral.service.impl;

import dev.codenation.errorcentral.dto.UserDTO;
import dev.codenation.errorcentral.entity.User;
import dev.codenation.errorcentral.mappers.UserMapper;
import dev.codenation.errorcentral.repository.UserRepository;
import dev.codenation.errorcentral.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        Page<User> users = this.userRepository.findAll(pageable);
        return new PageImpl<>(userMapper.map(users.getContent()), users.getPageable(), users.getTotalElements());
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
