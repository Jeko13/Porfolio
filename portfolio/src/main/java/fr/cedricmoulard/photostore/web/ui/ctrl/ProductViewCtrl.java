package fr.cedricmoulard.photostore.web.ui.ctrl;

import java.util.List;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;

import fr.cedricmoulard.photostore.model.DAOs;
import fr.cedricmoulard.photostore.model.bean.Product;

/**
 * @author zkessentials store
 * 
 *         This is the controller for the product view as referenced in
 *         index.zul
 * 
 */
public class ProductViewCtrl extends SelectorComposer<Div> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4327599559929787819L;

	@Wire
	private Grid prodGrid;

	@Override
	public void doAfterCompose(Div comp) throws Exception {
		super.doAfterCompose(comp);

		List<Product> prods = DAOs.getProductDAO().findAll();

		ListModelList<Product> prodModel = new ListModelList<Product>(prods);
		prodGrid.setModel(prodModel);
	}
	
}
