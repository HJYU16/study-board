package com.fastcampus.studyboard.repository;

import com.fastcampus.studyboard.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
