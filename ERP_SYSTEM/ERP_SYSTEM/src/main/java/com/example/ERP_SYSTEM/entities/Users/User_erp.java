package com.example.ERP_SYSTEM.entities.Users;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
/**
 * Die Klasse User_erp repräsentiert einen Benutzer in einem ERP-System (Enterprise Resource Planning).
 * Sie enthält Informationen wie Benutzername, Passwort, E-Mail und zugewiesene Rollen.
 * Die Klasse ist als JPA-Entity implementiert, um die Persistenz in einer relationalen Datenbank zu ermöglichen.
 */
@Entity
@Table(name ="users")
public class User_erp {
     /**
     * Eindeutige Identifikationsnummer des Benutzers. Wird automatisch von der Datenbank generiert.
     */
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private  Integer id;
     /**
     * Der Benutzername des Benutzers. Darf nicht null sein und hat eine maximale Länge von 255 Zeichen.
     */
      @Column(name="username", length = 255, nullable = false)
      private String username;
    /**
     * Das Passwort des Benutzers. Darf nicht null sein und hat eine maximale Länge von 255 Zeichen.
     */
      @Column(name="password", length = 255, nullable = false)
      private String  password ;
    /**
     * Die E-Mail-Adresse des Benutzers. Darf nicht null sein und hat eine maximale Länge von 255 Zeichen.
     */
      @Column(name="email", length = 255, nullable = false)
      private String  email;
    /**
     * Gibt an, ob der Benutzer aktiviert ist (true) oder deaktiviert ist (false).
     */
      @Column(name="enable")
      private boolean enable;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "role_users" ,joinColumns =@JoinColumn(name="user_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName ="id"))
    private List<Role> roleList = new ArrayList<>();


    public User_erp() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public User_erp( String username, String password, String email, boolean enable, List<Role> roleList) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.enable = enable;
        this.roleList = roleList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    /*
    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }*/
    @Override
    public String toString() {
        return "User_erp{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                ", roleList=" + roleList +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
