package stitchr.stitcher2mvc.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stitchr.stitcher2mvc.models.PatternCrawler;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PatternDao extends CrudRepository<PatternCrawler, Integer> {

}
