package security.myself.jwt20230725.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import security.myself.jwt20230725.model.UserAuth;

public interface UserRepository extends JpaRepository<UserAuth, UUID>
{
    Optional<UserAuth>                  findByLoginId(String loginId);
}
