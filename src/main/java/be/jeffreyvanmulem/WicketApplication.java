package be.jeffreyvanmulem;

import be.jeffreyvanmulem.controller.HomePage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 *
 */
public class WicketApplication extends WebApplication
{    	
	public WicketApplication() {

	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */

	@Override
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		//getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		//getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext));
	}
}
