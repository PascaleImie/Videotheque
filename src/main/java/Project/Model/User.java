package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pascale on 13/01/2017.
 */
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter private long id;

    @NotEmpty
    @Column(name="NOM")
    @Getter @Setter private String nom;


    @NotEmpty
    @Column(name="prenom")
    @Getter @Setter private String prenom;


    @NotEmpty
    @Email
    @Column(name="email",unique = true)
    @Getter @Setter private String email;

    @NotEmpty
    @Column(name="mdp", length = 255)
    @Size(min = 6)
    @Getter @Setter private String mdp;

    @NotEmpty
    @Column(name="role")
    @Getter @Setter private String role;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    @Getter @Setter private List<Film> films;

    public User(){}

    public User(String email, String mdp){

        this.email=email;
        this.mdp=mdp;
    }

    public User(String nom, String prenom, String email, String mdp, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", role='" + role + '\'' +
                ", films=" + films +
                '}';
    }
}
