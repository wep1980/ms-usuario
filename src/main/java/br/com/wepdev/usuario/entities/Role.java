package br.com.wepdev.usuario.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_role")
public class Role implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleNome;



    public Role() {
    }


    public Role(Long id, String roleNome) {
        this.id = id;
        this.roleNome = roleNome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleNome() {
        return roleNome;
    }

    public void setRoleNome(String roleNome) {
        this.roleNome = roleNome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(roleNome, role.roleNome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleNome);
    }
}
