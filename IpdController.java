package com.datastack.thehealthcare.ipd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.ipd.dto.DetailsData;
import com.datastack.thehealthcare.ipd.dto.IpdAccommodationDto;
import com.datastack.thehealthcare.ipd.dto.IpdBillPaymentDto;
import com.datastack.thehealthcare.ipd.dto.IpdBillingDto;
import com.datastack.thehealthcare.ipd.dto.IpdBookingDto;
import com.datastack.thehealthcare.ipd.dto.IpdDoctorDetailsDto;
import com.datastack.thehealthcare.ipd.dto.IpdPaymentDetailsDto;
import com.datastack.thehealthcare.ipd.dto.ResponseDto;
import com.datastack.thehealthcare.ipd.entity.IpdBooking;
import com.datastack.thehealthcare.ipd.service.IpdServices;

@RestController
@RequestMapping("/ipd")
public class IpdController {
@Autowired
IpdServices ipdServices;
@GetMapping("/getIpdMaster/{clinicId}")
public ResponseEntity<ResponseDto> getOccupation(@PathVariable Long clinicId){
	return new ResponseEntity<>(ipdServices.getIpdMasterData(clinicId), HttpStatus.OK);
}

@GetMapping("/getAccommodationDetails/{id}")
public ResponseEntity<List<DetailsData>> getAccommodationDetails(@PathVariable Long id){
	return new ResponseEntity<>(ipdServices.getAccommodationDetails(id), HttpStatus.OK);
}

@PostMapping("/ipdBooking")
public ResponseEntity<IpdBooking> patientRegistartion(@RequestBody IpdBookingDto ipdBookingDto){
return new ResponseEntity<>(ipdServices.ipdBooking(ipdBookingDto), HttpStatus.OK);
}

@PostMapping("/ipdAccommodation")
public ResponseEntity<IpdBooking> patientRegistartion(@RequestBody IpdAccommodationDto ipdAccommodationDto){
return new ResponseEntity<>(ipdServices.ipdAccommodationBooking(ipdAccommodationDto), HttpStatus.OK);
}

@PostMapping("/ipdPaymentDetails")
public ResponseEntity<IpdBooking> patientPayment(@RequestBody IpdPaymentDetailsDto ipdAccommodationDto){
return new ResponseEntity<>(ipdServices.ipdPaymentBooking(ipdAccommodationDto), HttpStatus.OK);
}

@PostMapping("/ipdDoctorBooking")
public ResponseEntity<IpdBooking> patientRegistartion(@RequestBody IpdDoctorDetailsDto ipdDoctorDetailsDto){
return new ResponseEntity<>(ipdServices.ipdDoctorBooking(ipdDoctorDetailsDto), HttpStatus.OK);
}


@GetMapping("/getPaymentInformation/{patinetBookingId}")
public ResponseEntity<IpdPaymentDetailsDto> getPaymentInformation(@PathVariable Long patinetBookingId){
	return new ResponseEntity<>(ipdServices.getPaymentDetails(patinetBookingId), HttpStatus.OK);
}

@GetMapping("/updateOperationStatus/{bookingId}/{status}")
public ResponseEntity<Boolean> updateOperationStatus(@PathVariable Long bookingId,@PathVariable Long status){
	return new ResponseEntity<>(ipdServices.updateOperationStatus(bookingId, status), HttpStatus.OK);
}

@GetMapping("/generateIpdBill/{patinetBookingId}")
public ResponseEntity<IpdBillingDto> generateIpdBill(@PathVariable Long patinetBookingId){
	return new ResponseEntity<>(ipdServices.generateIpdBill(patinetBookingId), HttpStatus.OK);
}

@PostMapping("/ipdBillPayment")
public ResponseEntity<Boolean> ipdBillPayment(@RequestBody IpdBillPaymentDto ipdBillPayment){
return new ResponseEntity<>(ipdServices.ipdBillPayment(ipdBillPayment), HttpStatus.OK);
}
}
