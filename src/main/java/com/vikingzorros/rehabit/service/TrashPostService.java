package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.TrashPost;

import java.util.List;

public interface TrashPostService {

    List<TrashPost> findAllTrashPosts();
    TrashPost findById(int id);
    void save(TrashPost trashPost);
    void deleteById(int id);
}
