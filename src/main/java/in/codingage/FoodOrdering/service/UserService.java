package in.codingage.FoodOrdering.service;

import in.codingage.FoodOrdering.model.User;
import in.codingage.FoodOrdering.model.request.UserSignIn;
import in.codingage.FoodOrdering.model.request.UserSignUp;

import java.util.List;

public interface UserService {
    User signUp(UserSignUp userSignUp);

    User signIn(UserSignIn userSignIn);

    List<User> getAllUser();
}
