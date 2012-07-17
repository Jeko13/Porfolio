package fr.cedricmoulard.photostore.web.ui.ctrl;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;

import fr.cedricmoulard.photostore.model.DAOs;
import fr.cedricmoulard.photostore.model.bean.Order;

public class OrderViewViewModel  {
	private Order selectedItem;

	public Order getSelectedItem() {
		return selectedItem;
	}
	
	@NotifyChange("selectedItem")
	public void setSelectedItem(Order selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	public List<Order> getOrders() {
		List<Order> orders = DAOs.getOrderDAO().findByUser(UserUtils.getCurrentUserId());
		return orders;
	}
	
	@Command
	@NotifyChange({"orders", "selectedItem"})
	public void cancelOrder() {
		if (getSelectedItem() == null) {
			return;
		}
		
		DAOs.getOrderDAO().cancelOrder(getSelectedItem().getId());
		setSelectedItem(null);
	}
	
	@GlobalCommand
	@NotifyChange("orders")
	public void updateOrders() {
		//no post processing needed
	}
}
