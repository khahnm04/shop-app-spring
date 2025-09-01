package com.projects.shopapp.services;

import com.projects.shopapp.dtos.UserDTO;
import com.projects.shopapp.exceptions.DataNotFoundException;
import com.projects.shopapp.models.User;

public interface IUserService {

    User createUser(UserDTO userDTO) throws DataNotFoundException;

    String login(String phoneNumber, String password);

}
