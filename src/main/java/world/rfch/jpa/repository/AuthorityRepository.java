package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByAuthority(String authority);
}
