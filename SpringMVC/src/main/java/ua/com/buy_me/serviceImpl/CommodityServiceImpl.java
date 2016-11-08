package ua.com.buy_me.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.buy_me.dto.CommodityDto;
import ua.com.buy_me.dto.DtoUtilMapper;
import ua.com.buy_me.entity.Commodity;
import ua.com.buy_me.entity.User;
import ua.com.buy_me.repository.CommodityRepository;
import ua.com.buy_me.repository.UserRepository;
import ua.com.buy_me.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService{

	@Autowired
	private CommodityRepository commodityRepository;
	
	public void save(Commodity commodity){
		commodityRepository.save(commodity);
	}

	public List<Commodity> findAll() {
		// TODO Auto-generated method stub
		return commodityRepository.findAll();
	}

	public Commodity findOneUser(int id) {
		// TODO Auto-generated method stub
		return commodityRepository.findOne(id);
	}

	public void delete(int id) {
		commodityRepository.delete(id);
		
	}

	@Override
	public Commodity findByName(String name) {
	
		return commodityRepository.findByName(name);
	}

	@Override
	public List<CommodityDto> findAllDto() {
	
		return DtoUtilMapper.listCommodityToCommodityDto(commodityRepository.findAll());
	}
}
