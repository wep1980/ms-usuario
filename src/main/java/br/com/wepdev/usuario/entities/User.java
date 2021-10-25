package br.com.wepdev.usuario.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER) // Dados dos perfis(Role) sera carregado automaticamente com os dados do usuario
    @JoinTable(name = "tb_user_role", // Nome da tabela que sera criada no banco por ter um relacionamento manyToMany
    joinColumns = @JoinColumn(name = "user_id"), // Nome da chave estrangeira da tabela Usuario que ficara na terceira tabela criada pelo banco
    inverseJoinColumns = @JoinColumn(name = "role_id") // Nome da chave estrangeira da tabela Role que ficara na terceira tabela criada pelo banco
    )
    private Set<Role> roles = new HashSet<>();


    public User() {
    }


    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User usuario = (User) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
