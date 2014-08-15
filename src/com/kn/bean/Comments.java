package com.kn.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "comments")
@XmlRootElement(name = "comments")
public class Comments implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private Date created_at;
	private String text;
	private String source;
	private String username;
	private long zhihuId;
	private String reply_comment;

	public Comments() {
		super();
	}

	public Comments(long id) {
		super();
		this.id = id;
	}
	
	public Comments(long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	public Comments(long id, long zhihuId) {
		super();
		this.id = id;
		this.zhihuId = zhihuId;
	}
	
	public Comments(long id, String username, long zhihuId) {
		super();
		this.id = id;
		this.username = username;
		this.zhihuId = zhihuId;
	}
	
	public Comments(String username, long zhihuId) {
		super();
		this.username = username;
		this.zhihuId = zhihuId;
	}

	public Comments(long id, Date created_at, String text, String source,
			String username, int zhihuId, String reply_comment) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.text = text;
		this.source = source;
		this.username = username;
		this.zhihuId = zhihuId;
		this.reply_comment = reply_comment;
	}

	@Id
	@Column(name = "commentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "created_at")
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Column(name = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "source")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "zhihuId")
	public long getZhihuId() {
		return zhihuId;
	}

	public void setZhihuId(long zhihuId) {
		this.zhihuId = zhihuId;
	}

	@Column(name = "reply_comment")
	public String getReply_comment() {
		return reply_comment;
	}

	public void setReply_comment(String reply_comment) {
		this.reply_comment = reply_comment;
	}

}
