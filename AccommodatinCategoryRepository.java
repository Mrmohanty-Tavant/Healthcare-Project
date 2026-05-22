package com.datastack.thehealthcare.ipd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ipd.entity.AccommodatinCategory;
import com.datastack.thehealthcare.ipd.entity.AccommodatinDetails;
@Repository
public interface AccommodatinCategoryRepository extends JpaRepository<AccommodatinCategory, Long>{
List<AccommodatinCategory> findByClinicId(Long id);

@Query("SELECT ad FROM AccommodatinDetails ad " +
        "WHERE ad.accommodationCategory.id = :categoryId " +
        "AND ad.bookingStatus = :bookingStatus")
 List<AccommodatinDetails> findByCategoryIdAndBookingStatus(@Param("categoryId") Long categoryId,
                                                            @Param("bookingStatus") boolean bookingStatus);

@Query("SELECT ad FROM AccommodatinDetails ad " +
        "WHERE ad.accommodationCategory.id = :categoryId " +
        "AND ad.id = :accoId")
 AccommodatinDetails findByCategoryIdAndAcoId(@Param("categoryId") Long categoryId,
                                                            @Param("accoId") Long accoId);

@Query("select count(c) from AccommodatinCategory p join p.accommodatinDetails c where c.bookingStatus = ?1")
int findCountOfBedAvailability(boolean bookingStatus);

@Modifying
@Query("update AccommodatinDetails ad set ad.bookingStatus=:status " +
        "WHERE ad.accommodationCategory.id = :categoryId " +
        "AND ad.id = :accoId")
 Integer updateBookingStatus(@Param("status") Boolean status, @Param("categoryId") Long categoryId,
                                                            @Param("accoId") Long accoId);
}
