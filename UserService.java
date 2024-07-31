package org.hyperskill.learning;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService implements CommandLineRunner {

    private final UserDBRepository userRepository;
    private final MyMapper myMapper;

    public UserService(UserDBRepository userRepository, MyMapper myMapper) {
        this.userRepository = userRepository;
        this.myMapper = myMapper;
    }

    @PostConstruct
    void generateUsers() {
        userRepository.save(new UserDB(1, "Øystein", "oysbak@gmail.com", LocalDate.now()));
        userRepository.save(new UserDB(2, "Elin", "elinBet@gmail.com", LocalDate.now()));
    }

    public List<UserDTO> getAllUsers() {
        // here we use the mapper to transform a User into a UserDTO
        return userRepository.findAll()
                .stream()
                .map(myMapper::convertUserToDTO)
                .collect(Collectors.toList());
    }

    public List<UserDB> getAllUserDBs() {
        return getAllUsers()
                .stream()
                .map(myMapper::convertDTOToUser)
                .collect(Collectors.toList());
    }

    public void run(String... args) {
        System.out.println("Running...");
        System.out.println("-------------------------------------");
        userRepository.findAll().forEach(System.out::println);
        System.out.println("-------------------------------------");
        getAllUsers().forEach(System.out::println);
        System.out.println("-------------------------------------");
        getAllUserDBs().forEach(System.out::println);
    }
}
