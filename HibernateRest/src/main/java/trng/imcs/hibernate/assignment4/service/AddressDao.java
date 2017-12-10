package trng.imcs.hibernate.assignment4.service;

import trng.imcs.hibernate.assignment4.bean.Address;

public interface AddressDao {
	Address updateAddress(Address address);
	int deleteAddress(Long custId);
}
