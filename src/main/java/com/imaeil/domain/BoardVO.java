package com.imaeil.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BoardVO extends DefaultVO {
	private long seq;
	private String title;
	private String content;
	private UserVO userVO;
}
