package com.vikingzorros.rehabit.configs;

import com.vikingzorros.rehabit.entities.User;
import com.vikingzorros.rehabit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      User theUser = userService.findByUserName(username);

      if(theUser==null)
          throw new UsernameNotFoundException("user : 404 ");

        return new UserPrincipal(theUser);
    }
}
