package project.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.dto.ShopDto;
import project.mapper.ShopMapper;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopMapper shopMapper;	
	
	@Value("${application.upload-path}")
	private String uploadPath;

	@Override
	public List<ShopDto> selectShopList() throws Exception {
		return shopMapper.selectShopList();
	}

	@Override
	public ShopDto selectShopByShopIdx(int shopIdx) {
		return shopMapper.selectShopByShopIdx(shopIdx);
	}

	@Override
	public int updateShop(ShopDto shopDto) throws Exception {
		return shopMapper.updateShop(shopDto);
	}

	@Override
	public int registShop(ShopDto shopDto, MultipartFile[] files) throws Exception {

//		final String UPLOAD_DIR = "c:/java/upload/";

		if (files != null) {
			for (MultipartFile mf : files) {
				String originFileName = mf.getOriginalFilename();
//				String savedFileName = UUID.randomUUID().toString();
				File f = new File(uploadPath + originFileName);
				mf.transferTo(f);
				shopDto.setShopImage(uploadPath + originFileName);
			}
		}
		return shopMapper.registShop(shopDto);
	}

	@Override
	public List<ShopDto> selectShopCategory() throws Exception {
		return shopMapper.selectShopCategory();
	}

	@Override
	public int deleteShop(int shopIdx) throws Exception {		
		return shopMapper.deleteShop(shopIdx);
	}

}
