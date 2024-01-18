package com.training.Springboot.service;

import java.util.List;


import com.training.Springboot.entity.User;

public interface UserService {
 List<User> getUsers();
User addUser(User user);
User getUserById(int id);
void updateUser(int id,User user);
User getUserByFirstName(String firstname);
String deleteUserById(int id);

}
