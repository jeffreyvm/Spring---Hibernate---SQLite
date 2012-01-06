package be.jeffreyvanmulem.controller;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
    
    private static final long serialVersionUID = 1L;

        
    public HomePage(final PageParameters parameters) {
    //    mySpringBean.foo();
        System.out.println(parameters.get("test"));
    }
}
