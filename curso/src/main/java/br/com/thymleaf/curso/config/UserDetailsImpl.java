package br.com.thymleaf.curso.config;

import br.com.thymleaf.curso.model.entity.UserModel;
import br.com.thymleaf.curso.model.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsImpl implements UserDetailsService {


    final UserRepository userRepository;
    public UserDetailsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username).get();
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true, true,
        userModel.getAuthorities());
    }


}
