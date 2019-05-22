package practice.demoPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practice.demoPractice.model.HelloModel;

import java.util.List;

public interface HelloRepository extends JpaRepository<HelloModel, Integer> {
@Query ("select h from HelloModel  h where id > :count")
List<HelloModel> getAllGreater(@Param("count") int count);
}
