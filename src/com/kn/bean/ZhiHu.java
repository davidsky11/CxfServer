package com.kn.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "zhihu")
@XmlRootElement(name = "zhihu")
public class ZhiHu {

	private long id;
	private Date created_at;
	//private String idstr;
	private String text;
	private User user;
	//private Geo geo;
	private int reposts_count;
	private int comments_count;
	private int attitudes_count;
	private int mievel;
	private String pic_urls;
	private List<Comments> comments = new ArrayList<Comments>();

	@Id
	@Column(name="zhid")
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

	/*public String getIdstr() {
		return idstr;
	}

	public void setIdstr(String idstr) {
		this.idstr = idstr;
	}*/

	@Column(name = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "username")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}*/

	@Column(name = "reposts_count")
	public int getReposts_count() {
		return reposts_count;
	}

	public void setReposts_count(int reposts_count) {
		this.reposts_count = reposts_count;
	}

	@Column(name = "comments_count")
	public int getComments_count() {
		return comments_count;
	}

	public void setComments_count(int comments_count) {
		this.comments_count = comments_count;
	}

	@Column(name = "attitudes_count")
	public int getAttitudes_count() {
		return attitudes_count;
	}

	public void setAttitudes_count(int attitudes_count) {
		this.attitudes_count = attitudes_count;
	}

	@Column(name = "mievel")
	public int getMievel() {
		return mievel;
	}

	public void setMievel(int mievel) {
		this.mievel = mievel;
	}

	@Column(name = "pic_urls")
	public String getPic_urls() {
		return pic_urls;
	}

	public void setPic_urls(String pic_urls) {
		this.pic_urls = pic_urls;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "zhihuId")
	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

}
