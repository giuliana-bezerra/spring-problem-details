package br.com.giulianabezerra.springproblemdetails;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  Map<String, User> users = new HashMap<>();

  public Collection<User> create(User newUser) {
    if (users.containsKey(newUser.username()))
      throw new ConflictException("user already exists");
    users.put(newUser.username(), newUser);

    return users.values();
  }

}
