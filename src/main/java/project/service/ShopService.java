package project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.dto.ShopDto;

@Service
public interface ShopService {
	
	List<ShopDto> selectShopList() throws Exception;
	public ShopDto selectShopByShopIdx(int shopIdx);
	public int updateShop(ShopDto shopDto) throws Exception;	
	public int registShop(ShopDto shopDto, MultipartFile[] files) throws Exception;	
	List<ShopDto> selectShopCategory() throws Exception;
	public int deleteShop(int shopIdx) throws Exception;
}
