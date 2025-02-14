package dev.erkaneren.CreditModuleChallenge.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryOf<T> extends JpaRepository<T, Long> {
}
