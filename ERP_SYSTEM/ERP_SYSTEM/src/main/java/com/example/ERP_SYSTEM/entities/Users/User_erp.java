package com.example.ERP_SYSTEM.entities.Users;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="users")
public class User_erp {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private  Integer id;
      @Column(name="username", length = 255, nullable = false)
      private String username;
      @Column(name="password", length = 255, nullable = false)
      private String  password ;
    @Column(name="email", length = 255, nullable = false)
      private String  email;
    @Column(name="enable")
      private boolean enable;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "role_users" ,joinColumns =@JoinColumn(name="user_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",columnDefinition = "id"))
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

    public void setPassword(String password) {
        this.password = password;
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
}
