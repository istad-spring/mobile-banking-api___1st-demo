package co.istad.mbanking.api.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer id;
    private String name;
    private String gender;
    private String oneSignalId;
    private String studentCardId;
    private Boolean isStudent;
    private Boolean isDeleted;

    // Auth feature
    private String email;
    private String password;
    private Boolean isVerified;
    private String verifiedCode;
}
