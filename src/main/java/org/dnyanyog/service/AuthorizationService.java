package org.dnyanyog.service;

import java.util.List;
import org.dnyanyog.dto.AuthorizationRequest;
import org.dnyanyog.dto.AuthorizationResponse;

public interface AuthorizationService {

  AuthorizationResponse Authorize(AuthorizationRequest Request);

  List<AuthorizationResponse> getAllAuthors();
}
