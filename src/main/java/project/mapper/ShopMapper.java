package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import project.dto.ShopDto;

@Mapper
public interface ShopMapper {	
	
	List<ShopDto> selectShopList() throws Exception;
	public ShopDto selectShopByShopIdx(int shopIdx);
	public int updateShop(ShopDto shopDto) throws Exception;	
	public int registShop(ShopDto shopDto) throws Exception;
	List<ShopDto> selectShopCategory() throws Exception;
	public int deleteShop(int shopIdx) throws Exception;

}
