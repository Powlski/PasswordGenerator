package Powlski;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class PasswordController {

    @GetMapping("randomPassword/{length}")
    public String randomPassword(@PathVariable int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\\$%&/()=?";
        String password = "";
        int value;

        for (int i = 0; i < length; i++)
        {
            value = new Random().ints(1,characters.length()).findFirst().getAsInt();
            password += characters.charAt(value) ;
        }
        return password;
    }
}
