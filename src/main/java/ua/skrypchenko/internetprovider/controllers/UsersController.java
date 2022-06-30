package ua.skrypchenko.internetprovider.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.skrypchenko.internetprovider.dao.UserDao;
import ua.skrypchenko.internetprovider.entity.UserEntity;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String getAllUsers() {
        String a = "afdadadasdasf";
        List<UserEntity> users = userDao.findAll();

        return users.toString();
    }
}
