package bd.ohedulalam.springSecurity.Controller;

import bd.ohedulalam.springSecurity.model.User;
import bd.ohedulalam.springSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/user/save")
    public User saveByAdmin(@RequestBody User user){
        String pwd = user.getPassword();
        String encrp =bCryptPasswordEncoder.encode(pwd);
        user.setPassword(encrp);
        return userRepository.save(user);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/all")
    public String hello(){
        return "hello ...";
    }
}
