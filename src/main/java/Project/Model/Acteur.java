package Project.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pascale on 16/03/2017.
 */
@Entity
@Table(name="Acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    @Getter
    @Setter
    private long id;

    @Column(name="nom")
    @Getter @Setter private String nom;

    @Column(name="prenom")
    @Getter @Setter private String prenom;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "acteurs")
    @Getter @Setter private List<Film> films;



    public Acteur() {}

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
