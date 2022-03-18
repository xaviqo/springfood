package tech.xavi.springfood.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account")
public class Account {

    @Column(name = "account_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 40, nullable = false)
    private String password;

    @Column(name = "role", length = 10, nullable = false)
    private int role;
}
