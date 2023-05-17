package co.istad.mbanking.api.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String gender;
    private String oneSignalId;
    private String studentCardId;
    private Boolean isStudent;
    private Boolean isDeleted;

    // Auth feature info
    private String email;
    private String password;
    private Boolean isVerified;
    private String verifiedCode;

    // User has roles
    private List<Role> roles;

}
