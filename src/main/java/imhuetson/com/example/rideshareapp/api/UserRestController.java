package imhuetson.com.example.rideshareapp.api;

import imhuetson.com.example.rideshareapp.domain.User;
import imhuetson.com.example.rideshareapp.dto.UserDTO;
import imhuetson.com.example.rideshareapp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserRepository userRepo;

    public UserRestController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        List<UserDTO> users = new ArrayList<>();

        for (User user : userRepo.findAll()) {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setFullName(user.getFullName());
            dto.setEmail(user.getEmail());
            users.add(dto);
        }
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

}
