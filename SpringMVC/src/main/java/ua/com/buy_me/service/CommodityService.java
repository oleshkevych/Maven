package ua.com.buy_me.service;

import java.util.List;

import ua.com.buy_me.dto.CommodityDto;
import ua.com.buy_me.entity.Commodity;

public interface CommodityService {

	void save(Commodity commodity);

//	List<Commodity> findAll();

	Commodity findOneUser(int id);

	void delete(int id);

	Commodity findByName(String name);
	
	List<CommodityDto> findAllDto();
}
