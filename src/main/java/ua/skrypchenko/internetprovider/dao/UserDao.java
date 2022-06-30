package ua.skrypchenko.internetprovider.dao;

import ua.skrypchenko.internetprovider.entity.UserEntity;

import java.util.List;

public interface UserDao {
    public List<UserEntity> findAll();
}
