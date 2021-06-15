package com.pensionManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pensionManagementSystem.model.PensionDetail;

public interface PensionDetailsRepo extends JpaRepository<PensionDetail, String>{

}
