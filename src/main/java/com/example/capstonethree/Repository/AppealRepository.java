package com.example.capstonethree.Repository;

import com.example.capstonethree.Model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealRepository extends JpaRepository<Appeal,Integer> {
    Appeal findAppealByCasseId(Integer id);
}
