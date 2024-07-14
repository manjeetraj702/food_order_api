package in.codingage.FoodOrdering.service.impl;

import in.codingage.FoodOrdering.model.User;
import in.codingage.FoodOrdering.model.request.user.UserSignIn;
import in.codingage.FoodOrdering.model.request.user.UserSignUp;
import in.codingage.FoodOrdering.repository.UserRepository;
import in.codingage.FoodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User signUp(UserSignUp userSignUp) {
        User userCheck = userRepository.findByUserName(userSignUp.getUserName());
        if (userCheck == null) {
            User user = new User();
            user.setUserName(userSignUp.getUserName());
            user.setRole(userSignUp.getRole());
            user.setPassword(userSignUp.getPassword());
            user.setEmail(userSignUp.getEmail());
            return userRepository.save(user);
        }
        else {
            return new User();
        }
    }

    @Override
    public User signIn(UserSignIn userSignIn) {

        User user = userRepository.findByUserName(userSignIn.getUserName());
        if (user != null && user.getPassword().equals(userSignIn.getPassword())) {
            return user;
        } else {
            return new User();
        }
    }


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Integer userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }
}
