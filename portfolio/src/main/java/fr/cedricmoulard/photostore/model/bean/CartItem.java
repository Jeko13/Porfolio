package fr.cedricmoulard.photostore.model.bean;

/**
 * @author zkessentials store
 * 
 *         This class provides a representation of a {@code CartItem}
 * 
 */
public class CartItem {

	private Product product;
	private Photo photo;
	private int amount;

	public CartItem(Photo photo,Product product) {
		super();
		this.product = product;
		this.photo = photo;
	}

	public Product getProduct() {
		return product;
	}

	public int getAmount() {
		return amount;
	}

	public void add(int amount) {
		this.amount += amount;
	}

	public float getSubTotal() {
		return product.getPrice() * amount;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
}
