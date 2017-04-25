package Project.Form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Pascale on 13/01/2017.
 */

public class UserRegisterForm implements Serializable {

    @NotEmpty
    @Getter @Setter private String nom;

    @NotEmpty
    @Getter @Setter private String prenom;

    @NotEmpty
    @Email
    @Getter @Setter private String email;

    @NotEmpty
    @Getter @Setter private String role;

    public UserRegisterForm() {
    }

    public UserRegisterForm(String nom, String prenom, String email,String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRegisterForm{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
