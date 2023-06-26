package project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import project.dto.UserDto;
import project.mapper.UserMapper;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userMapper.selectUserByUserId(username);
		log.debug(">>>>>>>>>>>>>");
		log.debug(userDto.toString());		
		
		if (userDto == null) {
			throw new UsernameNotFoundException(username);
		}		
		return new User(userDto.getUserId(), userDto.getUserPassword(), 
				true, true, true, true, new ArrayList<>());
	}

	@Override
	public UserDto login(UserDto userDto) throws Exception {
		return userMapper.login(userDto);
	}

	@Override
	public int registUser(UserDto userDto) throws Exception {
		userDto.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
		return userMapper.registUser(userDto);
	}

	@Override
	public UserDto selectUserByUserId(String userId) {
		return userMapper.selectUserByUserId(userId);
	}

	@Override
	public UserDto selectUserByUserIdx(int userIdx) {
		return userMapper.selectUserByUserIdx(userIdx);
	}

	@Override
	public int updateUser(UserDto userDto) throws Exception {
		return userMapper.updateUser(userDto);
	}

	@Override
	public List<UserDto> selectUserList() throws Exception {
		return userMapper.selectUserList();
	}

	@Override
	public int adminCash(UserDto userDto) throws Exception {
		return userMapper.adminCash(userDto);
	}

}
