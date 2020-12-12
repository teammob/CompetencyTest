package com.test.scrumconnect.CompetencyTest.repository;

import com.test.scrumconnect.CompetencyTest.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData,Long> {
}
