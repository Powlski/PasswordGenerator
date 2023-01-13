package Powlski;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
public class PasswordController {

    @GetMapping("randomPassword/{length}")
    public String randomPassword(@PathVariable int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\\$%&/()=?";
        String password = "";
        Random random = new Random();
        int value;

        for (int i = 0; i < length; i++)
        {
            value = random.nextInt(characters.length());
            password += characters.charAt(value) ;
        }
        return password;
    }
}
