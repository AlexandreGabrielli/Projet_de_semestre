package heigvd.ch.segfaultapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity

@Table(name = "Utilisateur")
public class Utilisateur  implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "utilisateur_id")
    private Integer utilisateurID;

    @Column(name = "nom_utilisateur")
    @Getter
    @Setter
    private String nomUtilisateur;

    @Column(name = "mail_utilisateur")
    @Getter
    @Setter
    private String mailUtilisateur;

    @Column(name = "mot_de_passe")
    @Getter
    @Setter
    @JsonIgnore // Cacher mot de passe
    private String motDePasse;

    @Column(name = "role_utilisateur")
    @Getter
    @Setter
    private int roleUtilisateur;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "Appartient",
            joinColumns = @JoinColumn(name ="departement_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    private Set<Departement> departementSet;

    @Getter
    @ManyToOne
    @JoinColumn(name = "role_utilisateur", referencedColumnName = "role_id", insertable= false, updatable=false)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return motDePasse;
    }

    @Override
    public String getUsername() {
        return nomUtilisateur;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.nomUtilisateur = username;
    }

    public void setPassword(String password) {
        this.motDePasse = password;
    }


    /*
    @OneToMany(mappedBy = "Utilisateur")
    private Set<Vote> voteSet;
*/
/*
    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "Vote",
            joinColumns = @JoinColumn(name ="utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id")
    )
    private Set<Message> messageSet;
*/


}
