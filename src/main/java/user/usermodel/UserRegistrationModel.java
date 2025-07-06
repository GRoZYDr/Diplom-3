package user.usermodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class UserRegistrationModel {
    private String email;
    private String password;
    private String name;
}
