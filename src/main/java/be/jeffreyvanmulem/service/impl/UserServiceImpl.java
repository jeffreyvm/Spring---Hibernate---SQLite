package be.jeffreyvanmulem.service.impl;

import be.jeffreyvanmulem.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 06/01/12
 * Time: 12:52
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService{

    public String testUserService() {
        return "this is a test for the userservice";
    }
}
