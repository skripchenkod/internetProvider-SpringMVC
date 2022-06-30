package ua.skrypchenko.internetprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "balance_id")
    private BalanceEntity balance;

    @OneToOne(mappedBy = "role_id")
    private RoleEntity role;

}
