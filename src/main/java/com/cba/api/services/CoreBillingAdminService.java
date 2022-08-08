package com.cba.api.services;

import java.util.List;

import com.cba.api.dto.PackageTypeDTO;
import com.cba.api.dto.UserDTO;
import com.cba.entity.PackageType;
import com.cba.entity.Subscription;

public interface CoreBillingAdminService {
	
	public List<PackageType> fetchPackages();

	public String authenticate(UserDTO userDto) throws Exception;

	public String addPackageType(PackageTypeDTO packagetypedto) throws Exception;

	public List<Subscription> listAllSubscriptions() throws Exception;

	public String editPackageType(PackageTypeDTO packagetypedto) throws Exception;

}
