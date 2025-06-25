package mobile.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddUserData {
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userPasswordConfirm;
}
