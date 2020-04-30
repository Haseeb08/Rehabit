package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.BlockUser;

import java.util.List;

public interface BlockUserService {

    List<BlockUser> findAllBlockedUsers();
    BlockUser findById(int id);
    void save(BlockUser theUser);
    void deleteById(int id);


}
