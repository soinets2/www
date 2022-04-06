package com.imaeil.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UserVO extends DefaultVO {	
	private long seq;
	private String id;
	private String password;
	private UserInfoVO infoVO;
}
