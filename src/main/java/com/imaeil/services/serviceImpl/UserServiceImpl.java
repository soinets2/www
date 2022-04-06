package com.imaeil.services.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imaeil.domain.UserVO;
import com.imaeil.mapper.UserInfoMapper;
import com.imaeil.mapper.UserMapper;
import com.imaeil.services.service.UserService;

import lombok.AllArgsConstructor;

@Service("userServiceImpl")
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	@Resource(name = "userMapper")
	private UserMapper userMapper;
	
	@Resource(name = "userInfoMapper")
	private UserInfoMapper userInfoMapper;
	
	public UserVO selectUser(long seq) {
		UserVO userVO = userMapper.getUserSeq(seq);
		
		if(userVO == null) {
			return null;
		} else {
			userVO.setInfoVO(userInfoMapper.getUserInfo(userVO));
		}
		
		return userVO;
	}
	
	public UserVO selectUser(String id) {
		UserVO userVO = userMapper.getUserId(id);
		
		if(userVO == null) {
			return null;
		} else {
			userVO.setInfoVO(userInfoMapper.getUserInfo(userVO));
		}
		
		return userVO;
	}
}
