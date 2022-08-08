package com.cba.api.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cba.api.dto.PackageTypeDTO;
import com.cba.api.dto.UserDTO;
import com.cba.api.exceptions.UnknownUserException;
import com.cba.api.helper.CoreBillingAPIHelper;
import com.cba.api.repository.PackageTypeRepository;
import com.cba.api.repository.SubscriptionRepository;
import com.cba.api.repository.UsersRepository;
import com.cba.api.services.CoreBillingAdminService;
import com.cba.api.utils.PasswordEncryption;
import com.cba.entity.PackageType;
import com.cba.entity.Subscription;
import com.cba.entity.Users;


@Transactional
@Service
public class CoreBillingAdminServiceImpl implements CoreBillingAdminService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	PackageTypeRepository packageTypeRepository;
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	private final Logger logger=LoggerFactory.getLogger(CoreBillingAdminServiceImpl.class);
	
	CoreBillingAPIHelper objectEntityMapper = new CoreBillingAPIHelper();
	
	@Override
	public String authenticate(UserDTO userDto) throws Exception {

		try {
			String encryptedPassword = PasswordEncryption.toHexString(PasswordEncryption.getSHA(userDto.getToken()));
			Users user = usersRepository.findByEmailAndToken(userDto.getEmail(), encryptedPassword);
			if (user == null) {
				throw new UnknownUserException("User Not Found");
			} else {
				return "Success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public List<PackageType> fetchPackages() {
		return packageTypeRepository.findAll();
	}

	@Override
	public String addPackageType(PackageTypeDTO packagetypedto) throws Exception {
		PackageType packageType = objectEntityMapper.getPackageEntity(packagetypedto);
		try {
			packageTypeRepository.save(packageType);
			return "success";
		} catch (Exception e) {
			logger.error("Exception::" + e);
			throw e;
		}
	}



	@Override
	public String editPackageType(PackageTypeDTO packagetypedto) throws Exception {

		try {
			Integer packagetypeId = packagetypedto.getPkgTypeId();
			if (packageTypeRepository.existsById(packagetypeId)) {
				PackageType packageType = packageTypeRepository.findById(packagetypeId).get();
				BeanUtils.copyProperties(packagetypedto, packageType);
				packageTypeRepository.save(packageType);
				return "success";
			} else {
				throw new Exception("Package Type with given ID  " + packagetypeId + " Does not exists");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Subscription> listAllSubscriptions() throws Exception {

		return null;
	}

}
