package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.UserData;
import org.dnyanyog.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserManagementService {

  public Optional<AddUserResponse> addUser(AddUserRequest request) throws Exception;

  public Object addUpdateUser(AddUserRequest userRequest) throws Exception;

  public List<Users> getAllUser();

  public List<Long> getAllUserIds();

  public AddUserResponse getSingleUser(Long userId) throws Exception;

  AddUserResponse addUpdatesUser(UserData userData);
}
