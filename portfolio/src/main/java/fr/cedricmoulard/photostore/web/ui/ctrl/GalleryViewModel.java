package fr.cedricmoulard.photostore.web.ui.ctrl;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zul.Group;
import org.zkoss.zul.Groupfoot;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import fr.cedricmoulard.photostore.model.DAOs;
import fr.cedricmoulard.photostore.model.PhotoComparator;
import fr.cedricmoulard.photostore.model.PhotoDAO;
import fr.cedricmoulard.photostore.model.PhotoGroupingModel;
import fr.cedricmoulard.photostore.model.ProductDAO;
import fr.cedricmoulard.photostore.model.bean.Photo;
import fr.cedricmoulard.photostore.model.bean.Product;
import fr.cedricmoulard.photostore.web.ShoppingCart;

public class GalleryViewModel {

	private Photo selectedItem;

	public Photo getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Photo selectedItem) {
		this.selectedItem = selectedItem;
	}

	public List<Photo> getPhotos() {
		return DAOs.getPhotoDAO().findAll();

	}
	
	public PhotoGroupingModel getGroupingPhotos() {
		return new PhotoGroupingModel(DAOs.getPhotoDAO().findAll(), new PhotoComparator(), true);

	}

	public ShoppingCart getShoppingCart() {
		return UserUtils.getShoppingCart();
	}
	
	@Command
	@NotifyChange("photos")
	public void move(@BindingParam("event") DropEvent event) {
		Listitem dragged = (Listitem) event.getDragged();
		Listitem target = (Listitem) event.getTarget();
		Listbox parent = (Listbox) dragged.getParent();
		
		parent.insertBefore(dragged, target);
		
		List<Component> components = parent.getChildren();
		PhotoDAO photoDao = DAOs.getPhotoDAO();
		for(Component component : components){
			
			if(component instanceof Listitem){
				Photo photo = ((Listitem) component).getValue();
				photo.setIndex(((Listitem) component).getIndex());
				photoDao.save(photo);
				
			}
		}
		
	}

	@Command
	@NotifyChange("groupingPhotos")
	public void moveGrid(@BindingParam("event") DropEvent event) {
		Row dragged = (Row) event.getDragged();
		Row target = (Row) event.getTarget();
		Rows parent = (Rows) dragged.getParent();

		parent.insertBefore(dragged, target);

		List<Component> components = parent.getChildren();
		PhotoDAO photoDao = DAOs.getPhotoDAO();
		for (Component component : components) {

			if (component instanceof Group) {

			} else if (component instanceof Groupfoot) {

			} else if (component instanceof Row) {
				Photo photo = ((Row) component).getValue();
				photo.setIndex(((Row) component).getIndex());
				photoDao.save(photo);

			}
		}

	}

	@Command
	@NotifyChange("shoppingCart")
	public void addCart(@BindingParam("photo") Photo photo) {
		ProductDAO productDAO = DAOs.getProductDAO();
		List<Product> products = productDAO.findAll();

		ShoppingCart shoppingCart = getShoppingCart();
		shoppingCart.add(photo, products.get(0), (int) products.get(0).getPrice());

	}

}
