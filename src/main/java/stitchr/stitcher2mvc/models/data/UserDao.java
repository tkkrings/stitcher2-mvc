package stitchr.stitcher2mvc.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stitchr.stitcher2mvc.models.User;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername (String username);

    User findByUid(int uid);
}