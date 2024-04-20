package org.dnyanyog.service;

import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;
import org.dnyanyog.common.ResponseCodes;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.UserData;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {

  Logger logger = LoggerFactory.getLogger(UserManagementService.class);
  @Autowired UsersRepository userRepo;
  @Autowired AddUserResponse userResponse;
  @Autowired private List<Long> userIds;
  @Autowired EncryptionService encryptionService;

  public Optional<AddUserResponse> addUser(AddUserRequest request) throws Exception {

    Users usersTable = new Users();

    usersTable.setAge(request.getAge());
    usersTable.setEmail(request.getEmail());
    usersTable.setPassword(encryptionService.encryp(request.getPassword()));
    usersTable.setUsername(request.getUsername());

    usersTable = userRepo.save(usersTable);
    //		Users usersTable=Users.getInstance()
    //				.setAge(request.getAge())
    //		        .setEmail(request.getEmail())
    //		        .setPassword(request.getPassword())
    //		        .setUsername(request.getUsername());
    // .setUserId(request.getUser_id());

    userResponse.setMessage(ResponseCodes.ADD_USER_SUCCESS.getMessage());
    userResponse.setStatus(ResponseCodes.ADD_USER_SUCCESS.getStatus());
    userResponse.setUserId(usersTable.getUserId());
    userResponse.setStatus(ResponseCodes.USER_FOUND_SUCCESS.getStatus());
    userResponse.setMessage(ResponseCodes.USER_FOUND_SUCCESS.getMessage());
    System.out.println(usersTable.getEmail());
    System.out.println(usersTable.getUsername());
    System.out.println(usersTable.getPassword());
    userResponse.setUserId(usersTable.getUserId());
    userResponse.getUserData().setEmail(usersTable.getEmail());
    userResponse.getUserData().setUsername(usersTable.getUsername());
    userResponse.getUserData().setAge(usersTable.getAge());

    return Optional.of(userResponse);
  }

  public AddUserResponse getSingleUser(Long userId) {

    Optional<Users> receivedData = userRepo.findById(userId);

    if (receivedData.isEmpty()) {
      userResponse.setStatus(ResponseCodes.USER_NOT_FOUND.getStatus());
      userResponse.setMessage(ResponseCodes.USER_NOT_FOUND.getMessage());
    } else {
      Users user = receivedData.get();
      userResponse.setStatus(ResponseCodes.USER_FOUND_SUCCESS.getStatus());
      userResponse.setMessage(ResponseCodes.USER_FOUND_SUCCESS.getMessage());
      userResponse.setUserId(user.getUserId());
      userResponse.getUserData().setEmail(user.getEmail());
      userResponse.getUserData().setUsername(user.getUsername());
      userResponse.getUserData().setPassword(user.getPassword());
      userResponse.getUserData().setAge(user.getAge());
    }
    return userResponse;
  }

  public List<Users> getAllUser() {
    return userRepo.findAll();
  }

  public List<Long> getAllUserIds() {

    List<Users> users = userRepo.findAll();

    for (Users user : users) {
      if (nonNull(user)) {
        userIds.add(user.getUserId());
      }
    }
    return userIds;
  }

  @Override
  public Object addUpdateUser(AddUserRequest userRequest) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AddUserResponse addUpdatesUser(UserData userData) {
    // TODO Auto-generated method stub
    return null;
  }
}
