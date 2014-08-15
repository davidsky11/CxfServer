package com.kn.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_zhihu_comments")
@IdClass(UZC.class)
public class UZC implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	private int zhihuId;
	private int commentsId;

	public UZC() {

	}

	public UZC(User user) {
		super();
		this.user = user;
	}

	public UZC(User user, int zhihuId) {
		super();
		this.user = user;
		this.zhihuId = zhihuId;
	}

	public UZC(User user, int zhihuId, int commentsId) {
		super();
		this.user = user;
		this.zhihuId = zhihuId;
		this.commentsId = commentsId;
	}

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@Column(name = "zhihuId")
	public int getZhihuId() {
		return zhihuId;
	}

	public void setZhihuId(int zhihuId) {
		this.zhihuId = zhihuId;
	}

	@Id
	@Column(name = "commentsId")
	public int getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(int commentsId) {
		this.commentsId = commentsId;
	}

}
