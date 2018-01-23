package dke.pr.g3.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dke.pr.g3.*;
import dke.pr.g3.db.HibernateUtil;

public class WebAppHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HibernateUtil.shutdown();
	}

}
