package dev.codenation.errorcentral.mappers;

import dev.codenation.errorcentral.dto.UserDTO;
import dev.codenation.errorcentral.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
    })
    UserDTO map(User user);

    List<UserDTO> map(List<User> users);
}
