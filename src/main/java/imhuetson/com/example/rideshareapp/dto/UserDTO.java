package imhuetson.com.example.rideshareapp.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String fullName;
    @Getter
    @Setter
    private String email;

    public UserDTO() {}
}
