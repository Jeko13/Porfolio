package fr.cedricmoulard.photostore.web.ui.ctrl;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;

import fr.cedricmoulard.photostore.web.ShoppingCart;
import fr.cedricmoulard.photostore.web.UserCredentialManager;

public class UserUtils {
	public static Long getCurrentUserId() {
		Long userId = UserCredentialManager.getIntance().getUser()
				.getId();
		return userId;
	}
	
	public static ShoppingCart getShoppingCart() {
		Session session = Executions.getCurrent().getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (cart == null) {
			session.setAttribute("ShoppingCart", cart = new ShoppingCart());
		}
		return cart;
	}
}
