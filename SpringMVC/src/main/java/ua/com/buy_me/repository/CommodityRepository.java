package ua.com.buy_me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.buy_me.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Integer>{

	@Query("select c from Commodity c where c.name =:name")
	Commodity findByName(@Param(value="name") String name);
	
}
