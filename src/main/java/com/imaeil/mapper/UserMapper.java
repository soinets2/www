package com.imaeil.mapper;

import com.imaeil.domain.UserVO;

public interface UserMapper {
	public UserVO getUserId(String id);
	public UserVO getUserSeq(long seq);
}
