package stitchr.stitcher2mvc.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stitchr.stitcher2mvc.models.Yarn;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface YarnDao extends CrudRepository<Yarn, Integer> {
}
