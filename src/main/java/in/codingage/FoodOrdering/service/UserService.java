package in.codingage.FoodOrdering.service;

import in.codingage.FoodOrdering.model.User;
import in.codingage.FoodOrdering.model.request.user.UserSignIn;
import in.codingage.FoodOrdering.model.request.user.UserSignUp;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User signUp(UserSignUp userSignUp);

    User signIn(UserSignIn userSignIn);

    List<User> getAllUser();
    Optional<User> getById(Integer userId);
}
