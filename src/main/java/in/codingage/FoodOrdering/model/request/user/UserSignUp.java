package in.codingage.FoodOrdering.model.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserSignUp {
    private  String userName;
    private String password;
    private String email;
    private String role;

}
