package fr.cedricmoulard.photostore.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 * @author zkessentials store
 * 
 *         This class provides a representation of an {@code OrderItem}
 * 
 */
@Entity
public class OrderItem {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	@ManyToOne
	private Photo photo;
	
	@ManyToOne
	private Product product;
	
	private String name;
	private float price;
	private int quantity;

	public OrderItem() {
	}

	public OrderItem(Long id, Photo photo,Product product, String name,
			float price, int quantity) {
		super();
		if (id != null)
			this.id = id;
		this.setPhoto(photo);
		this.setProduct(product);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
