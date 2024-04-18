package com.example.capstonethree.Repository;

import com.example.capstonethree.Model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence,Integer> {

    Evidence findEvidenceById(Integer id);


    List<Evidence> findAllByAppeal_Id(Integer appealId);
}
