package com.maslov.repository;

import com.maslov.entity.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // Принцип взаимодействия сущности и Jpa
public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {
}
