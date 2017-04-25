package Project.Form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by Pascale on 13/01/2017.
 */

public class UserConnectForm implements Serializable {

    @NotEmpty
    @Email
    @Getter @Setter private String email;

    @NotEmpty
    @Email
    @Getter @Setter private String mdp;


    public UserConnectForm() {
    }

    public UserConnectForm(String email, String mdp) {

        this.email = email;
        this.mdp = mdp;
    }
}
