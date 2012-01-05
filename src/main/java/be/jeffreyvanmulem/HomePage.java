package be.jeffreyvanmulem;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {
    
    private static final long serialVersionUID = 1L;
    
    @SpringBean
    private MySpringBean mySpringBean;
        
        
    public HomePage(final PageParameters parameters) {
        mySpringBean.foo();
    }
}
