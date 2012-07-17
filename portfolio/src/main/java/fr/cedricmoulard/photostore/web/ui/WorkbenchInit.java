package fr.cedricmoulard.photostore.web.ui;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import fr.cedricmoulard.photostore.web.UserCredentialManager;

/**
 * @author zkessentials store
 * 
 *         This is a class which catches the initialization of a ZK page and
 *         redirects accordingly if no user credentials are found
 * 
 */
public class WorkbenchInit implements Initiator {

	/*
	 * Invoked whhen the ZK Parser starts
	 */
	public void doInit(Page page, @SuppressWarnings("rawtypes") Map arg) throws Exception {
		UserCredentialManager.getIntance();
//		if (!UserCredentialManager.getIntance().isAuthenticated()) {
//			Executions.getCurrent().sendRedirect("login.zul");
//		}
	}

	public boolean doCatch(Throwable parsingError) throws Exception {
		return false;
	}

	public void doAfterCompose(Page page) throws Exception {
	}

	public void doFinally() throws Exception {
	}

}
