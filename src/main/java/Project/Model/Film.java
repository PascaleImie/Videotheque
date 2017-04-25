package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
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
@Table(name = "Film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_film")
    @Getter @Setter private long id_film;

    @Column(name="titre")
    @Getter @Setter private String titre;

    @Column(name="annee")
    @Getter @Setter private int annee;

    @Column(name="duree")
    @Getter @Setter private String duree;

    @Column(name="nationalite")
    @Getter @Setter private String nationalite;

    @Column(name="synopsis")
    @Type(type="text")
    @Getter @Setter private String synopsis;

    @Column(name="jaquette")
    @Getter @Setter private String jaquette;


   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="id_user", nullable = false)
   @Getter @Setter private User user;


    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="Film_Acteur", joinColumns=@JoinColumn(name="film_id"),
            inverseJoinColumns=@JoinColumn(name="acteur_id"))
    @Getter @Setter private List<Acteur> acteurs;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="id_realisateur", nullable = false)
    @Getter @Setter private Realisateur realisateur;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="Film_Genre", joinColumns=@JoinColumn(name="film_id"),
            inverseJoinColumns=@JoinColumn(name="genre_id"))
    @Getter @Setter private List<Genre> genres;




    public Film() {
    }

    public Film(String titre, int annee, String duree, String nationalite, String synopsis, String jaquette,
                User user, List<Acteur> acteurs, Realisateur realisateur, List<Genre> genres) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.nationalite = nationalite;
        this.synopsis = synopsis;
        this.jaquette = jaquette;
        this.user = user;
        this.acteurs = acteurs;
        this.realisateur = realisateur;
        this.genres = genres;
    }


    public Film(String titre, int annee, String duree, String nationalite, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.nationalite = nationalite;
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id_film=" + id_film +
                ", titre='" + titre + '\'' +
                ", annee=" + annee +
                ", duree='" + duree + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", jaquette='" + jaquette + '\'' +
                ", user=" + user +
                ", acteurs=" + acteurs +
                ", realisateur=" + realisateur +
                ", genres=" + genres +
                '}';
    }
}
