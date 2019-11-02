package win.mortalliao.jwt.controller;

import win.mortalliao.jwt.entity.User;
import win.mortalliao.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author mortalliao
 */
@RestController
@RequestMapping("/users")
public class TestController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public String getUsers() {
        return "getAll";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    User addUser(@RequestBody User addedUser) {
        userService.insert(addedUser);
        return addedUser;
    }

    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        return userService.selectById(id);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    //@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    //User updateUser(@PathVariable String id, @RequestBody User updatedUser) {
    //    updatedUser.setId(id);
    //    return repository.save(updatedUser);
    //}

    //@PreAuthorize("hasRole('ADMIN')")
    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    //User removeUser(@PathVariable String id) {
    //    User deletedUser = repository.findOne(id);
    //    repository.delete(id);
    //    return deletedUser;
    //}

    //@PostAuthorize("returnObject.userCode == principal.username or hasRole('ADMIN')")
    @PreAuthorize("(#username eq principal.username) or hasRole('ADMIN')")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public User getUserByUsername(@RequestParam(value="username") String username) {
        User byUsername = userService.findByUsername(username);
        return byUsername;
    }
}
