package org.hyperskill.learning;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyMapper {

    private final ModelMapper modelmapper;

    public MyMapper(ModelMapper modelmapper) {
        this.modelmapper = modelmapper;
    }

    UserDTO convertUserToDTO(UserDB userDB) {
        //return new UserDTO(userDB.getId(), userDB.getName(), userDB.getEmail());
        return modelmapper.map(userDB, UserDTO.class);
    }

    UserDB convertDTOToUser(UserDTO dto) {
        UserDB userDB = new UserDB(dto.getId(), dto.getName(), dto.getEmail(), null);
        userDB.setAccountCreatedAt(LocalDate.now());
        return userDB;
    }
}
