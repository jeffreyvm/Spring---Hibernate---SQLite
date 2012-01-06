package be.jeffreyvanmulem;

import be.jeffreyvanmulem.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 06/01/12
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/applicationContext.xml")
public class TestSpring{
    @Autowired
    private UserService userService;
    
    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void should_autowire(){
        assertNotNull(userService);
    }

    @Test
    public void should_get_entityManager(){
        assertNotNull(entityManager);
    }

}
