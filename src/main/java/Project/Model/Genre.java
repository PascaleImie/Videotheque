package Project.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pascale on 16/03/2017.
 */
@Entity
@Table(name="Genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    @Getter
    @Setter
    private long id;

    @Column(name="libelle")
    @Getter @Setter private String libelle;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
    @Getter @Setter private List<Film> films;



    public Genre() {}

    public Genre(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
}
