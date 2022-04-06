package com.imaeil.domain;

import java.util.Date;

import lombok.Data;

@Data
public class DefaultVO {
	private String use_yn = "Y";
	private String del_yn = "N";
	private String reg_seq;
	private Date reg_date;
	private String upd_seq;
	private Date upd_date;
}
