package maudev.portfolio.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maudev.portfolio.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    

    public User findByIdAndStatus(Long id , String status);
}
