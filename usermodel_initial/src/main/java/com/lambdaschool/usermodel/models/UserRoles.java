package com.lambdaschool.usermodel.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "userroles")
@IdClass(UserRolesId.class)
public class UserRoles extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = "roles")
    @JoinColumn(name = "userid")
    private User user;

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = "users")
    @JoinColumn(name = "roleid")
    private Role role;

    public UserRoles() {

    }

    public UserRoles(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        //two objects are equal?
        //this.userid = that.userid
        //this.roleid = that.romeid
        UserRoles that = (UserRoles) o;
        return ((this.user == null) ? 0 : this.getUser().getUserid()) == ((that.user == null) ? 0 : that.getUser().getUserid()) &&
               ((this.role == null) ? 0 : this.getRole().getRoleid()) == ((that.role == null) ? 0 : that.getRole().getRoleid());
    }

    @Override
    public int hashCode() {
        //return Objects.hash(user, role);
        return 37;
    }
}
