package tin.dev.com.tss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tin.dev.com.tss.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
