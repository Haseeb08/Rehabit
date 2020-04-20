package com.vikingzorros.rehabit.daorepositories;

import com.vikingzorros.rehabit.entities.MotivationalMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotivationalMessagesRepository extends JpaRepository<MotivationalMessage,Integer> {
}
