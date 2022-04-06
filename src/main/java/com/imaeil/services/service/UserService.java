package com.imaeil.services.service;

import com.imaeil.domain.UserVO;

public interface UserService {
	public UserVO selectUser(long seq);
	public UserVO selectUser(String id);
}
