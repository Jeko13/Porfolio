package fr.cedricmoulard.photostore.model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author zkessentials store
 * 
 *         This class provides a representation of a {@code Photo}
 * 
 */
@Entity
@Table(name = "photos")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "photoname")
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	private boolean available;
	private String imgPath;
	@Column(name = "photoindex")
	private int index;

	public Photo() {
	}

	public Photo(long id, String name, Date createDate, 
			boolean available, String imgPath,int index) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.available = available;
		this.imgPath = imgPath;
		this.index = index;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
