package nl.blueside.cateringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.Instant;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;

@Controller
@RequestMapping(path="/api")
public class UserController {

    @Autowired
	private UserRepository userRepository;

    /*
	@GetMapping(path="/users/{id}")
	public @ResponseBody User getAllUsersByDate(@PathVariable Long id)
    {
        return userRepository.findById(id);
	}
    */
    @GetMapping(path="/users")
	public @ResponseBody Iterable<User> getAllUsers()
    {
        return userRepository.findAll();
	}

	@PostMapping(path="/users")
	public @ResponseBody ResponseEntity<String> addUser(@RequestBody User user)
    {
    	userRepository.save(user);
        return ResponseEntity.ok().body(new JSONObject().put("status", "OK").toString());
	}

    //TODO: Create class for credentials?
    //TODO: Implement: https://www.baeldung.com/spring-security-oauth-jwt
	@PostMapping(path="/users/authenticate")
	public @ResponseBody ResponseEntity<User> login(@RequestBody String credentials)
    {
        
        JSONObject data = new JSONObject(credentials);
        System.out.println(data.getString("email"));
        User user = userRepository.findByEmail(data.getString("email"));

        if(user == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        
        // TODO: Hey, I know whats happening here. I'm just implement things step by step.
        //       Don't worry, we'll get rid of it when we understand JWT tokens a little better
        if(user.getPassword().equals(data.getString("password")))
        {
            user.setJwt("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImp0aSI6IjE4YzE5YzZlLTY3M2EtNGI2MC04ZjA1LTAxMTBkZTFiOGFmMSIsImlhdCI6MTUzNDM0ODI4MCwiZXhwIjoxNTM0MzUxODgwfQ.TxG5zcppaeuEKjv2S25hDKSVbQyOD9Xd7i5bPty47d8");
            return ResponseEntity.ok().body(user);
        }
        else
        {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
	}
    
    //TODO: Seperate class?
    //TODO: Validation
    @PostMapping(path="/users/register")
	public @ResponseBody ResponseEntity<String> register(@RequestBody User user)
    {
        //STUDY: https://www.baeldung.com/spring-security-registration
        //TODO: Check if the username doesn't already exists and let the caller know

        //TODO: Email verification
        //TODO: Resend verification
        //TODO: Password encoding: https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt
        //TODO: Password reset
        //TODO: Password strength verification
        //TODO: Password changing
        
        System.out.println(user.toString());
        userRepository.save(user);
        //user.setJwt("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImp0aSI6IjE4YzE5YzZlLTY3M2EtNGI2MC04ZjA1LTAxMTBkZTFiOGFmMSIsImlhdCI6MTUzNDM0ODI4MCwiZXhwIjoxNTM0MzUxODgwfQ.TxG5zcppaeuEKjv2S25hDKSVbQyOD9Xd7i5bPty47d8");
        return ResponseEntity.ok().body(new JSONObject().put("status", "OK").toString());
	}
}
