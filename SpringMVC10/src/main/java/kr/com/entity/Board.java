package kr.com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity //DataBase의 Table
@Data
public class Board { // VO<--ORM-->TABLE
	
	@Id // primary 키 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
	private Long idx;
	private String title;
	@Column(length =2000)
	private String content;
	@Column(updatable =false)
	private String writer;
	@Column(insertable = false, updatable =false, columnDefinition = "datetime default now()")
	private Date indate; // now()
	@Column(insertable = false, updatable =false, columnDefinition = "int default 0")
	private Long count;
}
