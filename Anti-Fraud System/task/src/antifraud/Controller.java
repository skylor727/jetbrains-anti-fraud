package antifraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    UserService userService;

    @GetMapping("/loggedin")
    public String loggedIn() {
        return "beep boop";
    }

    @GetMapping("/")
    public String greeting() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return "Hello world";
    }

    @PostMapping("/api/antifraud/transaction")
    public Map transaction(@RequestBody Transaction transaction) {
        HashMap<String, String> map = new HashMap<>();
        String transactionValidity = transaction.getTransactionValidity();
        map.put("result", transactionValidity);
        if (transaction.getAmount() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
        }
        return map;
    }


    @GetMapping("/user")
    public String user() {
        return "/user accessed";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin accessed";
    }


    @PostMapping("/api/auth/user")
    public UserInfo user(@RequestBody User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(user.getUserName());
        userInfo.setName(user.getName());
        userService.saveOrUpdate(user);
        userInfo.setId(user.getId());
        return userInfo;
    }
}
