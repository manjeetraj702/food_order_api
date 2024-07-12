package in.codingage.FoodOrdering.controller;

import in.codingage.FoodOrdering.model.User;
import in.codingage.FoodOrdering.model.request.user.UserSignIn;
import in.codingage.FoodOrdering.model.request.user.UserSignUp;
import in.codingage.FoodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserSignUp userSignUp) {

        return userService.signUp(userSignUp);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserSignIn userSignIn) {
        return userService.signIn(userSignIn);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

}
