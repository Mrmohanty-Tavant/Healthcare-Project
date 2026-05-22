package com.datastack.thehealthcare.ipd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datastack.thehealthcare.ipd.dto.DetailsData;
import com.datastack.thehealthcare.ipd.dto.IpdAccommodationDto;
import com.datastack.thehealthcare.ipd.dto.IpdBillPaymentDto;
import com.datastack.thehealthcare.ipd.dto.IpdBillingDto;
import com.datastack.thehealthcare.ipd.dto.IpdBookingDto;
import com.datastack.thehealthcare.ipd.dto.IpdDoctorDetailsDto;
import com.datastack.thehealthcare.ipd.dto.IpdPaymentDetailsDto;
import com.datastack.thehealthcare.ipd.dto.ResponseDto;
import com.datastack.thehealthcare.ipd.entity.IpdBooking;

@Service
public interface IpdServices {
	ResponseDto getIpdMasterData(Long clinincId);
	
	IpdBooking ipdBooking(IpdBookingDto ipdBookingDto);
	
	IpdBooking ipdAccommodationBooking(IpdAccommodationDto ipdAccommodationDto);
	
	IpdBooking ipdDoctorBooking(IpdDoctorDetailsDto ipdDoctorDetailsDto);
	
	IpdBooking ipdPaymentBooking(IpdPaymentDetailsDto ipdPaymentDetailsDto);
	
	List<DetailsData> getAccommodationDetails(Long id);
	
	IpdPaymentDetailsDto getPaymentDetails(Long bookingId);
	Boolean updateOperationStatus(Long bookingId, Long status);
	IpdBillingDto generateIpdBill(Long bookingId);
	Boolean ipdBillPayment(IpdBillPaymentDto ipdBill);
}
