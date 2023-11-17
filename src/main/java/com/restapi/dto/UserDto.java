package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.request.UserRequest;
import com.restapi.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDto {

    public UserResponse mapToUserResponse(List<AppUser> appUserList) {
        UserResponse userResponse = new UserResponse();

        ArrayList<UserRequest> userRequests = new ArrayList<>();
        for (AppUser appUser : appUserList) {
            userRequests.add(new UserRequest(appUser.getName()));
        }

        userResponse.setUserRequestList(userRequests);
        return userResponse;
    }
}
