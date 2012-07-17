package fr.cedricmoulard.photostore.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import fr.cedricmoulard.photostore.model.bean.CartItem;
import fr.cedricmoulard.photostore.model.bean.Photo;
import fr.cedricmoulard.photostore.model.bean.Product;

/**
 * @author zkessentials store
 * 
 *         This class provides a representation of a shopping cart
 * 
 */
public class ShoppingCart {

	private Map<Long, CartItem> items = Collections
			.synchronizedMap(new LinkedHashMap<Long, CartItem>());

	public List<CartItem> getItems() {
		return new ArrayList<CartItem>(items.values());
	}

	public CartItem getItem(long prodId) {
		return items.get(prodId);
	}

	private void add(CartItem item) {
		items.put(item.getPhoto().getId(), item);
	}

	public void add(Photo photo,Product prod, int amount) {
		
		CartItem item = this.getItem(photo.getId());
		if (item == null) {
			this.add(item = new CartItem(photo,prod));
			item.add(amount);
		} else {
			item.add(amount);
		}
		
	}

	public void remove(long id) {
		items.remove(id);
	}

	public void clear() {
		items.clear();
	}

	public float getTotalPrice() {
		float subTotal = 0;
		for (CartItem item : items.values()) {
			subTotal += item.getProduct().getPrice() * item.getAmount();
		}
		return subTotal;
	}

	public int getSize(){
		return items.size();
	}
}
