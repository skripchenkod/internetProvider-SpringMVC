package ua.skrypchenko.internetprovider.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ua.skrypchenko.internetprovider.entity.BalanceEntity;
import ua.skrypchenko.internetprovider.entity.RoleEntity;
import ua.skrypchenko.internetprovider.entity.UserEntity;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.*;

@Component
@Data
public class UsersDaoJdbcTemplateImpl implements UserDao {

    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    private final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";

    @Autowired
    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<UserEntity> findAll(){
        return template.query(SQL_SELECT_ALL_USERS, userRowMapper);
    }

    private final RowMapper<UserEntity> userRowMapper
            = (ResultSet resultSet, int i) -> {
        UserEntity user = new UserEntity();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(new RoleEntity());
        user.setBalance(new BalanceEntity());
        return user;
    };
}
