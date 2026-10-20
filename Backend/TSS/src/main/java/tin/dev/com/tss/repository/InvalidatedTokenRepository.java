package tin.dev.com.tss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tin.dev.com.tss.entity.InvalidatedToken;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {
}
