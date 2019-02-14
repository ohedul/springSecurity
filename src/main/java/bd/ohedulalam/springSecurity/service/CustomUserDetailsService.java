package bd.ohedulalam.springSecurity.service;

import bd.ohedulalam.springSecurity.model.User;
import bd.ohedulalam.springSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        CustomUserDetails userDetails = null;
        if(user != null){
            userDetails = new CustomUserDetails();
            userDetails.setEmail(user.getEmail());
            userDetails.setF_name(user.getF_name());
            userDetails.setL_name(user.getL_name());
            userDetails.setPassword(user.getPassword());
            userDetails.setMobile(user.getMobile());
            userDetails.setUser_id(user.getUser_id());
            userDetails.setRoles(user.getRoles());

        }else{
            throw new UsernameNotFoundException("User with this email " + s +" not found!");
        }

        return userDetails;
    }
}
