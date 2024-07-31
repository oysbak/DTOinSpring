package org.hyperskill.learning;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDBRepository extends JpaRepository<UserDB, Long> {
}
