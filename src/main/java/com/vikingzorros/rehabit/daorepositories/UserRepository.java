package com.vikingzorros.rehabit.daorepositories;

import com.vikingzorros.rehabit.entities.BlockUser;
import com.vikingzorros.rehabit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);

    User findByUserName(String userName);
}
