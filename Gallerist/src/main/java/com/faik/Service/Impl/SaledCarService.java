package com.faik.Service.Impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faik.Dto.CurrencyRatesResponse;
import com.faik.Dto.DtoCar;
import com.faik.Dto.DtoCustomer;
import com.faik.Dto.DtoGallerist;
import com.faik.Dto.DtoSaledCar;
import com.faik.Dto.DtoSaledCarIU;
import com.faik.Exception.BaseException;import com.faik.Exception.ErrorMessage;
import com.faik.Exception.MessageType;
import com.faik.Model.Account;
import com.faik.Model.Car;
import com.faik.Model.Customer;
import com.faik.Model.SaledCar;
import com.faik.Repository.*;
import com.faik.Service.ICurrencyRatesService;
import com.faik.Service.ISaledCarService;
import com.faik.Utils.DateUtils;
import com.faik.enums.CarStatusType;


@Service
public class SaledCarService  implements ISaledCarService{


	private static final Account Account = null;

	@Autowired	
	private SaledCarRepository saledCarRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private GalleristRepository galleristRepository;
	
	@Autowired
	private ICurrencyRatesService currencyRatesService;



	
	
	public BigDecimal converCustomerAmountToUSD(Account account) {
		CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));
		
		BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());
		BigDecimal customerUSDAmount = account.getAmount().divide(usd, 2, RoundingMode.HALF_UP);
		
		return customerUSDAmount;
	}
	
	public boolean checkCarStatus(Long carId) {
		Optional<Car> optCar = carRepository.findById(carId);
		if(optCar.isPresent() && optCar.get().getCarStatusType().name().equals(CarStatusType.SALED.name())) {
			return false;
		}
		return true;
	} 
	
	
	//ABD Para birimini Tl cinsine çeviriyoruz
	public BigDecimal remaningCustomerAmount(Account account, Car car) {
		BigDecimal customerUSDAmount = converCustomerAmountToUSD(account);
		BigDecimal remaningCustomerUSDAmount = customerUSDAmount.subtract(car.getPrice());
		
		CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates(DateUtils.getCurrentDate(new Date()),DateUtils.getCurrentDate(new Date()));
		BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());
		
		return remaningCustomerUSDAmount.multiply(usd);
	
	}
	
	public boolean checkAmount(DtoSaledCarIU dtoSaledCarIU) {
		Optional<Account> optCustomer= customerRepository.findById(dtoSaledCarIU.getCustomer_id());
		if(optCustomer.isEmpty()) {
			throw new BaseException(new ErrorMessage(dtoSaledCarIU.getCustomer_id().toString(), MessageType.GENERAL_EXCEPTION));
		}
		
		Optional<Car> optCar = carRepository.findById(dtoSaledCarIU.getCarId());
		if(optCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(dtoSaledCarIU.getCarId().toString(), MessageType.GENERAL_EXCEPTION));
		}
		
		BigDecimal customerUsdAmount = converCustomerAmountToUSD(optCustomer.get());
		
		if(customerUsdAmount.compareTo(optCar.get().getPrice()) == 0 || customerUsdAmount.compareTo(optCar.get().getPrice())>0) {
			return true;
		}
		return false;
		
	}
	
	
	private SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU) {
		SaledCar saledCar = new SaledCar();

		saledCar.setCreate_Time(new java.sql.Date(0));
		saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCustomer_id()).orElse(null));
		saledCar.setGallerist(galleristRepository.findById(dtoSaledCarIU.getGallerist_id()).orElse(null));
		saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));
		
		return saledCar;
	}
	
	@Override
	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU) {
		if(!checkAmount(dtoSaledCarIU)) {
			throw new BaseException(new ErrorMessage("", MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH));
		}
		
		if(!checkCarStatus(dtoSaledCarIU.getCarId())) {
			throw new BaseException( new ErrorMessage("", MessageType.CAR_STATUS_IS_ALREADY_SALED));
		}
		
		SaledCar savedSaledCar  = saledCarRepository.save(createSaledCar(dtoSaledCarIU));
		
		Car car = savedSaledCar.getCar();
		car.setCarStatusType(CarStatusType.SALED);
		
		carRepository.save(car);
		
		Customer customer = savedSaledCar.getCustomer();
		customer.getAccount().setAmount(remaningCustomerAmount(Account, car));
		
		
		return toDTO(savedSaledCar);
	}
	
	public DtoSaledCar toDTO(SaledCar saledcar) {
		DtoSaledCar dtoSaledCar = new DtoSaledCar();
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoCar dtoCar = new DtoCar();
		
		BeanUtils.copyProperties(saledcar, dtoSaledCar);
		BeanUtils.copyProperties(saledcar.getCustomer(), dtoCustomer);
		BeanUtils.copyProperties(saledcar.getGallerist(), dtoGallerist);
		BeanUtils.copyProperties(saledcar.getCar(), dtoCar);
		
		dtoSaledCar.setCustomer(dtoCustomer);
		dtoSaledCar.setGallerist(dtoGallerist);
		dtoSaledCar.setCar(dtoCar);
		
		return dtoSaledCar;	
	}
}
