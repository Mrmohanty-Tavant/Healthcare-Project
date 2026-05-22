package com.datastack.thehealthcare.ipd.service.impl;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datastack.thehealthcare.entity.master.DepartmentMaster;
import com.datastack.thehealthcare.entity.master.OccupationMaster;
import com.datastack.thehealthcare.entity.master.OperationMaster;
import com.datastack.thehealthcare.ipd.dto.DetailsData;
import com.datastack.thehealthcare.ipd.dto.IpdAccommodationDto;
import com.datastack.thehealthcare.ipd.dto.IpdBillPaymentDto;
import com.datastack.thehealthcare.ipd.dto.IpdBillingDto;
import com.datastack.thehealthcare.ipd.dto.IpdBookingDto;
import com.datastack.thehealthcare.ipd.dto.IpdDoctorDetailsDto;
import com.datastack.thehealthcare.ipd.dto.IpdPaymentDetailsDto;
import com.datastack.thehealthcare.ipd.dto.ResponseDto;
import com.datastack.thehealthcare.ipd.entity.AccommodatinCategory;
import com.datastack.thehealthcare.ipd.entity.AccommodatinDetails;
import com.datastack.thehealthcare.ipd.entity.IpdAccommodation;
import com.datastack.thehealthcare.ipd.entity.IpdBooking;
import com.datastack.thehealthcare.ipd.entity.IpdDoctorDetails;
import com.datastack.thehealthcare.ipd.entity.IpdPaymentDetails;
import com.datastack.thehealthcare.ipd.entity.IpdPaymentHistory;
import com.datastack.thehealthcare.ipd.repository.AccommodatinCategoryRepository;
import com.datastack.thehealthcare.ipd.repository.IpdBookingRepository;
import com.datastack.thehealthcare.ipd.repository.IpdPaymentHistoryRepository;
import com.datastack.thehealthcare.ipd.service.IpdServices;
import com.datastack.thehealthcare.ledger.entity.BrokerLedger;
import com.datastack.thehealthcare.ledger.entity.HospitalLedger;
import com.datastack.thehealthcare.ledger.repository.BrokerLedgerRepository;
import com.datastack.thehealthcare.ledger.repository.HospitalLedgerRepository;
import com.datastack.thehealthcare.repository.master.DepartmentMasterRepository;
import com.datastack.thehealthcare.repository.master.OccupationMasterRepository;
import com.datastack.thehealthcare.repository.master.OperationMasterRepository;
import com.datastack.thehealthcare.util.Common;
@Service
public class IpdServicesImpl implements IpdServices {
@Autowired
AccommodatinCategoryRepository accommodatinCategoryRepository;

@Autowired
IpdBookingRepository ipdBookingRepository;

@Autowired
OccupationMasterRepository occupationMasterRepository;

@Autowired
DepartmentMasterRepository departmentMasterRepository;

@Autowired
OperationMasterRepository operationMasterRepository;

@Autowired
BrokerLedgerRepository brokerLedgerRepository;

@Autowired
IpdPaymentHistoryRepository ipdPaymentHistoryRepository;

@Autowired
HospitalLedgerRepository hospitalLedgerRepository;
@Autowired
Common common;

	@Override
	public ResponseDto getIpdMasterData(Long clinincId) {
		List<DetailsData> operationList= Arrays.asList(DetailsData.builder()
				.label("BSKY")
				.value("1")
				.build(), DetailsData.builder()
				.label("Cash")
				.value("2")
				.build());
		List<AccommodatinCategory> data=accommodatinCategoryRepository.findByClinicId(clinincId);
		 List<DetailsData> category = data.stream()
	                .map(ac -> DetailsData.builder()
	                        .label(ac.getTypeOfAccommodation())
	                        .value(ac.getId().toString())
	                        .build())
	                .collect(Collectors.toList());

	        Map<Long, List<DetailsData>> map = data.stream()
	                .collect(Collectors.toMap(
	                        AccommodatinCategory::getId,
	                        ac -> ac.getAccommodatinDetails().stream()
	                                .map(dt -> DetailsData.builder()
	                                        .label(dt.getId().toString())
	                                        .value(dt.getName())
	                                        .build())
	                                .collect(Collectors.toList())
	                ));
	        
	        List<OccupationMaster> occupationList= occupationMasterRepository.findByLanguageIdAndVisible(1L, true);
	        
	        List<DetailsData> occupation = occupationList.stream()
	                .map(ac -> DetailsData.builder()
	                        .label(ac.getName())
	                        .value(ac.getMasterKey())
	                        .build())
	    	                .collect(Collectors.toList());
	        List<DepartmentMaster> departmentList=  departmentMasterRepository.findByLanguageId(1L);
	        List<DetailsData> departmenmt = departmentList.stream()
	                .map(ac -> DetailsData.builder()
	                        .label(ac.getDepartmentName())
	                        .value(ac.getMasterKey())
	                        .build())
	    	                .collect(Collectors.toList());
	        return ResponseDto.builder()
	        		.operationList(operationList)
	        		.occupation(occupation)
	        		.department(departmenmt)
	                .category(category)
	                .details(map)
	                .build();
	}
	@Override
	public IpdBooking ipdBooking(IpdBookingDto ipdBookingDto) {
		Long logedInId=common.getUserId();
		IpdBooking booking= IpdBooking.builder()
				.clinicId(ipdBookingDto.getClinicId())
				.admissionDate(new Date(System.currentTimeMillis()))
				.patinetId(ipdBookingDto.getPatinetId())
				.operationCategoryId(ipdBookingDto.getOperationCategoryId())
				.referalCategoryId(ipdBookingDto.getReferalCategoryId())
				.referalId(ipdBookingDto.getReferalId())
				.departMentId(ipdBookingDto.getDepartMentId())
				.operationId(ipdBookingDto.getOperationId())
				.accomodationSatus(false)
				.doctorAssignStatus(false)
				.paymentStatus(false)
				.dishchargeStatus(false)
				.operationStatus(0L)
				.doctorPaymentStatus(0L)
				.build();
		booking.setCreatedAt(new Date(System.currentTimeMillis()));
		booking.setModifiedAt(new Date(System.currentTimeMillis()));
		booking.setCreatedBy(logedInId);
		booking.setModifiedBy(logedInId);
		
		IpdAccommodation accommodation= IpdAccommodation.builder()
				.build();
		
		accommodation.setCreatedAt(new Date(System.currentTimeMillis()));
		accommodation.setModifiedAt(new Date(System.currentTimeMillis()));
		accommodation.setCreatedBy(logedInId);
		accommodation.setModifiedBy(logedInId);
		accommodation.setIpd(booking);
		
		booking.setAccomodation(Arrays.asList(accommodation));
		
	IpdDoctorDetails doctor=	IpdDoctorDetails.builder().build();
	doctor.setCreatedAt(new Date(System.currentTimeMillis()));
	doctor.setModifiedAt(new Date(System.currentTimeMillis()));
	doctor.setCreatedBy(logedInId);
	doctor.setModifiedBy(logedInId);
	doctor.setIpdBooking(booking);
	
	booking.setIpdDoctor(doctor);
	
	IpdPaymentDetails pd= IpdPaymentDetails.builder()
			.bedChargesPerDay(0.0)
			.operationCharges(0.0)
			.operationCategoryId(0L)
			.paymentType("NA")
			.ipdBooking(booking)
			.build();
	
	pd.setCreatedAt(new Date(System.currentTimeMillis()));
	pd.setModifiedAt(new Date(System.currentTimeMillis()));
	pd.setCreatedBy(logedInId);
	pd.setModifiedBy(logedInId);
	booking.setIpdPayment(pd);
	
	IpdBooking ipdBooking= ipdBookingRepository.save(booking);
	
	//Ledger Entry to broker
	BrokerLedger ledger= BrokerLedger.builder()
			.brokkerId(ipdBookingDto.getReferalId())
			.bookingId(ipdBooking.getId())
			.referralAmount(0.0)
			.paymentStatus(false)
			.build();
	ledger.setCreatedAt(new Date(System.currentTimeMillis()));
	ledger.setModifiedAt(new Date(System.currentTimeMillis()));
	ledger.setCreatedBy(logedInId);
	ledger.setModifiedBy(logedInId);
	brokerLedgerRepository.save(ledger);
	
	
		return ipdBooking;
	}
	@Override
	public IpdBooking ipdAccommodationBooking(IpdAccommodationDto ipdAccommodationDto) {
		Long logedInId=common.getUserId();
		IpdBooking book= new IpdBooking();
		Optional<IpdBooking> booking= ipdBookingRepository.findById(ipdAccommodationDto.getIpdBookingId());
		if(booking.isPresent()) {
			book=booking.get();
		}
         
		List<IpdAccommodation> details= book.getAccomodation();
		  for (IpdAccommodation ac : details) {
			  if(ac.getId().equals(ipdAccommodationDto.getId())) {
				  ac.setAccommodationCategoryId(ipdAccommodationDto.getAccommodationCategoryId());
				  ac.setAccommodationDetailsId(ipdAccommodationDto.getAccommodationDetailsId());
				  ac.setModifiedBy(logedInId);
				  ac.setModifiedAt(new Date(System.currentTimeMillis()));
			  }
		  }
		  book.setAccomodation(details);
		  book.setAccomodationSatus(true);
		  
		Optional<AccommodatinCategory> accOptional= 
				accommodatinCategoryRepository.findById(ipdAccommodationDto.getAccommodationCategoryId());
		
		accOptional.ifPresent(acc -> 
	    acc.getAccommodatinDetails().stream()
	        .filter(dts -> dts.getId().equals(ipdAccommodationDto.getAccommodationDetailsId()))
	        .findFirst()
	        .ifPresent(dts -> dts.setBookingStatus(true))
	);
		accommodatinCategoryRepository.save(accOptional.get());	
		 return ipdBookingRepository.save(book);
	}
	@Override
	public IpdBooking ipdDoctorBooking(IpdDoctorDetailsDto ipdDoctorDetailsDto) {
		IpdBooking book= new IpdBooking();
		Optional<IpdBooking> booking= ipdBookingRepository.findById(ipdDoctorDetailsDto.getIpdBookingId());
		if(booking.isPresent()) {
			book=booking.get();
		}
		book.setDoctorAssignStatus(true);
		book.setOperationStatus(1L);
		IpdDoctorDetails doctor=book.getIpdDoctor();
		doctor.setDotorId(ipdDoctorDetailsDto.getDoctorId());
		doctor.setAnesthesiaId(ipdDoctorDetailsDto.getAnesthesiaId());
        doctor.setOperationScheduleTime(ipdDoctorDetailsDto.getOtScheduleTime());
         doctor.setOtScheduleBy(common.getUserId());
		book.setIpdDoctor(doctor);
		return  ipdBookingRepository.save(book);
	}
	@Override
	public List<DetailsData> getAccommodationDetails(Long id) {
	List<AccommodatinDetails> details=	accommodatinCategoryRepository.findByCategoryIdAndBookingStatus(id, false);
		return details.stream()
	             .map(ac -> DetailsData.builder()
	                     .label(ac.getName())
	                     .value(ac.getId().toString())
	                     .build())
	             .collect(Collectors.toList());
	}
	@Override
	public IpdPaymentDetailsDto getPaymentDetails(Long bookingId) {
		IpdPaymentDetailsDto paymentDetails= new IpdPaymentDetailsDto();
		Optional<IpdBooking> booking= ipdBookingRepository.findById(bookingId);
		if(booking.isPresent()) {
		Optional<OperationMaster> operationMaster=	operationMasterRepository.findByMasterKeyAndLanguageId(booking.get().getOperationId(), 1L);
Optional<AccommodatinCategory> acCategory=accommodatinCategoryRepository.findById(booking.get().getAccomodation().get(0).getAccommodationCategoryId());
paymentDetails.setBookingId(bookingId);
paymentDetails.setOperationCategoryId(booking.get().getOperationCategoryId());
		if(operationMaster.isPresent() && acCategory.isPresent()) {
		if(booking.get().getOperationCategoryId()== 1 ) {
				paymentDetails.setBskyPackagePrice(operationMaster.get().getBskyPrice());
				if(acCategory.get().getMasterKey().contains("ward")) {
					paymentDetails.setBedCharges(0.0);
					paymentDetails.setAccoType("ward");
				}
				else {
				acCategory.ifPresent(acc -> 
			    acc.getAccommodatinDetails().stream()
			        .filter(dts -> dts.getId().equals(booking.get().getAccomodation().get(0).getAccommodationDetailsId()))
			        .findFirst()
			        .ifPresent(dts -> paymentDetails.setBedCharges(dts.getPrice())));
				paymentDetails.setAccoType("NA");
				}
			        
			      paymentDetails.setOperationCharges(0.0);
			}
		else {
			paymentDetails.setAccoType("NA");
			paymentDetails.setBskyPackagePrice(0.0);
		paymentDetails.setOperationCharges(operationMaster.get().getCashPackage());
		acCategory.ifPresent(acc -> 
	    acc.getAccommodatinDetails().stream()
	        .filter(dts -> dts.getId().equals(booking.get().getAccomodation().get(0).getAccommodationDetailsId()))
	        .findFirst()
	        .ifPresent(dts -> paymentDetails.setBedCharges(dts.getPrice())));
		}
		}
		paymentDetails.setPaymentCategory(common.getPaymentCategory(booking.get().getClinicId()));
		}
	
		return paymentDetails;
	}
	@Override
	public IpdBooking ipdPaymentBooking(IpdPaymentDetailsDto ipdPaymentDetailsDto) {
		Long logedInId=common.getUserId();
		IpdBooking book= new IpdBooking();
		Optional<IpdBooking> booking= ipdBookingRepository.findById(ipdPaymentDetailsDto.getBookingId());
		if(booking.isPresent()) {
			book=booking.get();
		}
		IpdPaymentDetails pd= book.getIpdPayment();
		pd.setBedChargesPerDay(ipdPaymentDetailsDto.getBedCharges());
		pd.setOperationCharges(ipdPaymentDetailsDto.getOperationCharges());
		pd.setOperationCategoryId(ipdPaymentDetailsDto.getOperationCategoryId());
		pd.setPaymentType(ipdPaymentDetailsDto.getAccoType());
		pd.setModifiedBy(logedInId);
		pd.setModifiedAt(new Date(System.currentTimeMillis()));
		book.setPaymentStatus(true);
		if(ipdPaymentDetailsDto.getAdvanceAmount()>0) {
			IpdPaymentHistory history= IpdPaymentHistory.builder()
					.paymentAmount(ipdPaymentDetailsDto.getAdvanceAmount())
					.comment(ipdPaymentDetailsDto.getComment())
					.modeOfPayment(ipdPaymentDetailsDto.getModeOfPayment())
					.incomeCategory(1L)
					.ipdBookingId(book.getId())
					.build();
			history.setCreatedAt(new Date(System.currentTimeMillis()));
			history.setModifiedAt(new Date(System.currentTimeMillis()));
			history.setCreatedBy(logedInId);
			history.setModifiedBy(logedInId);
			ipdPaymentHistoryRepository.save(history);
			HospitalLedger ledger = HospitalLedger.builder()
					.masterLedgerId(ipdPaymentDetailsDto.getModeOfPayment())
					.credit(ipdPaymentDetailsDto.getAdvanceAmount())
					.description("IPD Payment booking refernace id "+book.getId())
					.financeYear(common.getFinanceYear(book.getClinicId()))
					.paymentSource("IPD")
					.build();
			ledger.setCreatedAt(new Date(System.currentTimeMillis()));
			ledger.setModifiedAt(new Date(System.currentTimeMillis()));
			ledger.setCreatedBy(logedInId);
			ledger.setModifiedBy(logedInId);
			hospitalLedgerRepository.save(ledger);
		}	
		return ipdBookingRepository.save(book);
	}
	@Override
	public Boolean updateOperationStatus(Long bookingId, Long status) {
		Boolean response= false;
	Optional<IpdBooking> booking=	ipdBookingRepository.findById(bookingId);
	if(booking.isPresent()) {
		booking.get().setOperationStatus(status);
		if(status==3) {
			booking.get().setDoctorPaymentStatus(1L);
		}
		ipdBookingRepository.save(booking.get());
		response=true;
	}
		return response; 
	}
	@Override
	public IpdBillingDto generateIpdBill(Long bookingId) {
		IpdBillingDto billing= new IpdBillingDto();
		Double billingAmount;
		Double paidAmount=0.0;
		Double dueAmount;
		Optional<IpdBooking> booking=	ipdBookingRepository.findById(bookingId);
		if(booking.isPresent()) {
			billing.setBookingId(bookingId);
		 	 paidAmount=ipdPaymentHistoryRepository.sumValuePaymentAmountByIpdBookingId(bookingId);
		 	 if(paidAmount==null) {
		 		paidAmount=0.0; 
		 	 }
	IpdPaymentDetails payment= booking.get().getIpdPayment();
	     if(payment.getPaymentType().equals("package")) {
	    	 billingAmount=payment.getOperationCharges();
	    	 billing.setBillingAmount(billingAmount);
	    	 billing.setPaidAmount(paidAmount);
	    	 dueAmount=billingAmount-paidAmount;
	    	 billing.setDueAmount(dueAmount);	
	    	 billing.setPaymentCategory(common.getPaymentCategory(booking.get().getClinicId()));
	    	billing.setBookingType(payment.getPaymentType());	    	 }
	     else if(payment.getPaymentType().equals("")){
	    	 billingAmount=payment.getBedChargesPerDay();
	    	 billing.setBillingAmount(billingAmount);
	    	 billing.setPaidAmount(paidAmount);
	    	 dueAmount=billingAmount-paidAmount;
	    	 billing.setDueAmount(dueAmount);	
	    	 billing.setPaymentCategory(common.getPaymentCategory(booking.get().getClinicId()));
	    	 billing.setBookingType("bsky");
	     }
		}
		return billing;
	}
	@Transactional
	@Override
	public Boolean ipdBillPayment(IpdBillPaymentDto ipdBill) {
		try {
			Long logedInId=common.getUserId();
			Double payment=0.0;
			if(Objects.nonNull(ipdBill.getPaidAmount())) {
				payment=ipdBill.getPaidAmount();
			}
			IpdPaymentHistory history= IpdPaymentHistory.builder()
					.paymentAmount(payment)
					.comment(ipdBill.getComment())
					.modeOfPayment(ipdBill.getModeOfPayment())
					.incomeCategory(1L)
					.ipdBookingId(ipdBill.getBookingId())
					.build();
			history.setCreatedAt(new Date(System.currentTimeMillis()));
			history.setModifiedAt(new Date(System.currentTimeMillis()));
			history.setCreatedBy(logedInId);
			history.setModifiedBy(logedInId);
			IpdBooking book= new IpdBooking();
			Optional<IpdBooking> booking= ipdBookingRepository.findById(ipdBill.getBookingId());
			if(booking.isPresent()) {
				book=booking.get();
			}
			if(ipdBill.getTransactionType().equals("BP")) {
		
				  List<IpdAccommodation> accommodation = book.getAccomodation();
				  IpdAccommodation acco= accommodation.get(0);
				  accommodatinCategoryRepository.updateBookingStatus(false, acco.getAccommodationCategoryId(), acco.getAccommodationDetailsId());
				    book.setDishchargeStatus(true);
					IpdPaymentDetails pd= book.getIpdPayment();
			        pd.setTotalBillAmount(ipdBill.getTotalbillAmount());
			        pd.setDiscountAmount(ipdBill.getDiscountAmount());
					pd.setModifiedBy(logedInId);
					pd.setModifiedAt(new Date(System.currentTimeMillis()));
					ipdBookingRepository.save(book);
				
			}
			ipdPaymentHistoryRepository.save(history);
			HospitalLedger ledger = HospitalLedger.builder()
					.masterLedgerId(ipdBill.getModeOfPayment())
					.credit(ipdBill.getPaidAmount())
					.description("IPD Payment booking refernace id "+ipdBill.getBookingId())
					.paymentSource("IPD")
					.financeYear(common.getFinanceYear(book.getClinicId()))
					.build();
			ledger.setCreatedAt(new Date(System.currentTimeMillis()));
			ledger.setModifiedAt(new Date(System.currentTimeMillis()));
			ledger.setCreatedBy(logedInId);
			ledger.setModifiedBy(logedInId);
			hospitalLedgerRepository.save(ledger);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
