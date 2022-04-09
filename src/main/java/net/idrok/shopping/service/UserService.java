package net.idrok.shopping.service;

import net.idrok.shopping.entity.User;

import java.util.Optional;

public interface UserService extends CommonService<User> {

    Optional<User> getByLogin(String login);


}
