package org.dnyanyog.service;

import java.util.List;
import org.dnyanyog.common.ResponseCodes;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired UsersRepository userRepo;
  @Autowired Users user;
  @Autowired EncryptionService encryptionService;

  public LoginResponse validateUser(LoginRequest loginRequest) {

    LoginResponse response = new LoginResponse();

    List<Users> liUser =
        userRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

    if (liUser.size() == 1) {
      response.setStatus(ResponseCodes.LOGIN_SUCCESS.getStatus());
      response.setMessage(ResponseCodes.LOGIN_SUCCESS.getMessage());
    } else {
      response.setStatus(ResponseCodes.LOGIN_FAIL.getStatus());
      response.setMessage(ResponseCodes.LOGIN_FAIL.getMessage());
    }
    return response;
  }

  //    public LoginResponse validateUser(LoginRequest loginRequest) {
  //        LoginResponse response = new LoginResponse();
  //
  //        // Fetch the user from the database by username (assuming userRepo.findByUsername is
  // correctly implemented)
  //        Users user = userRepo.findByUsername(loginRequest.getUsername());
  //
  //        if (user != null) {
  //            try {
  //                String encryptedPasswordFromDatabase = user.getPassword();
  //
  //                // Decrypt the stored password for comparison
  //                EncryptionService decryptedStoredPassword =
  // decrypt(encryptedPasswordFromDatabase, generateAESKey());
  //
  //                // Check if the provided password matches the decrypted stored password
  //                if
  // (loginRequest.getPassword().equals(decryptedStoredPassword.getDecryptedPassword())) {
  //                    response.setStatus("Success");
  //                    response.setMessage("Login successful");
  //                } else {
  //                    response.setStatus("Fail");
  //                    response.setMessage("Login failed");
  //                }
  //            } catch (Exception e) {
  //                response.setStatus("Error");
  //                response.setMessage("An error occurred during login validation");
  //                e.printStackTrace(); // Handle or log the exception appropriately
  //            }
  //        } else {
  //            response.setStatus("Fail");
  //            response.setMessage("User not found");
  //        }
  //
  //        return response;
  //    }
  //
  //    private EncryptionService decrypt(String encryptedPasswordFromDatabase, SecretKey aesKey) {
  //        try {
  //            // Assuming EncryptionService has a method to decrypt the password
  //            return encryptService.decrypt(encryptedPasswordFromDatabase, aesKey);
  //        } catch (Exception e) {
  //            e.printStackTrace(); // Handle or log the exception appropriately
  //            return null;
  //        }
  //    }

  //    public LoginResponse validateUser(LoginRequest loginRequest) throws Exception {
  //		LoginResponse response = new LoginResponse();
  //
  //		List<Users> receivedData = userRepo.findByUsername(loginRequest.getUsername());
  //
  //		if (receivedData.size() == 1) {
  //			Users userData = receivedData.get(0);
  //			String encryptedPassword = userData.getPassword();
  //			String requestPassword = encryptionService.encryp(loginRequest.getPassword());
  //
  //			if (requestPassword.equalsIgnoreCase(encryptedPassword)) {
  //				response.setStatus("Success");
  //				response.setMessage("Login successful");
  //			} else {
  //				response.setStatus("Fail");
  //				response.setMessage("Username & Password Do Not Match");
  //			}
  //		} else {
  //			response.setStatus("Fail");
  //			response.setMessage("Request Username is Not present in the database");
  //		}
  //
  //		return response;
  //	}

}
