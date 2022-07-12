package antifraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/")
    public String greeting() {
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

    @PostMapping("/api/auth/user")
    public void user(@RequestBody User user) {
        userService.saveOrUpdate(user);
    }
}
