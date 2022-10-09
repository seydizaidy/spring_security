package com.zaidy.crudsecrest.webController;


import com.zaidy.crudsecrest.model.UserInfo;
import com.zaidy.crudsecrest.services.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/registration")
public class UserRegistrationController {
	private UserInfoService userInfoServiceService;
	public UserRegistrationController(UserInfoService userInfoServiceService)
	{
		super();
		this.userInfoServiceService = userInfoServiceService;
	}

	@PostMapping
	public void registerUserAccount(@RequestBody UserInfo userInfo) {

		userInfoServiceService.createUser(userInfo);

	}
}
