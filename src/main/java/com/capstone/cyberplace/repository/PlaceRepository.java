package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

	// get top 6
	@Query(value = "SELECT TOP(6) * from Place where status_place_id =1  ORDER BY counter_view DESC ", nativeQuery = true) // jpql
	List<Place> getTop6();

	// get all active
	@Query(value = "SELECT  * from Place where status_place_id =1  ORDER BY counter_view DESC ", nativeQuery = true) // jpql
	List<Place> getAll();

	// find by place id
	@Query(value = "SELECT  * from Place where place_id = :place_id AND status_place_id = 1", nativeQuery = true) // jpql
	Place getOneActiveByPlaceID(@Param("place_id") int place_id);

	// searchUltimate
	@Modifying
	@Query(value = "EXEC searchUltimate @title= :title , @districtID =:districtID "
			+ ", @roleID =:roleID , @mina =:mina , @maxa =:maxa , @minp =:minp , @maxp =:maxp ", nativeQuery = true) // jpql
	List<Place> listSearchPlace(@Param("title") String title, @Param("districtID") int districtID,
			@Param("roleID") int roleID, @Param("mina") float mina, @Param("maxa") float maxa,
			@Param("minp") float minp, @Param("maxp") float maxp);

	// check Status place

	@Query(value = "SELECT * FROM Place where place_id =:place_id  ", nativeQuery = true) // jpql
	Place getPlaceByPlaceID(@Param("place_id") int placeID);

	// get all

	@Query(value = "SELECT  * from Place  ", nativeQuery = true) // jpql
	Page<Place> getAllPageable(Pageable pageable);

	// insert
	@Modifying
	@Query(value = "INSERT INTO Place (owner_id , title , price , area , district_id ,ward_id , street_id\r\n"
			+ ", address ,  role_of_place_id , status_place_id , counter_view , frontispiece,home_direction, \r\n"
			+ "floors, bed_rooms, toilets,description,image_large , contact_name , contact_phone_number , contact_address , contact_email , date_post ) VALUES (:owner_id , :title , :price , :area , :district_id , :ward_id , :street_id "
			+ ", :address , :map_id , :role_of_place_id , :status_place_id , :counter_view , :frontispiece "
			+ ", :home_direction , :floors , :bed_rooms , :toilets , :description ,:image_large ,:contact_name , :contact_phone_number , :contact_address , :contact_email , :date_post ) ", nativeQuery = true) // jpql
	void insertPlace(@Param("owner_id") int userID, @Param("title") String title, @Param("price") float price,
			@Param("area") float area, @Param("district_id") int district_id, @Param("ward_id") int wardID,
			@Param("street_id") int streetID, @Param("address") String address,
			@Param("role_of_place_id") int roleOfPlaceID, @Param("status_place_id") int statusPlaceID,
			@Param("counter_view") int counterView, @Param("frontispiece") float frontispiece,
			@Param("home_direction") String home_direction, @Param("floors") int floors,
			@Param("bed_rooms") int bed_rooms, @Param("toilets") int toilets, @Param("description") String description,
			@Param("image_large") String imageLarge, @Param("contact_name") String contactName,
			@Param("contact_phone_number") String contactPhoneNumber, @Param("contact_address") String contactAddress,
			@Param("contact_email") String contactEmail, @Param("date_post") String datePost);

	// get one by map id

	@Query(value = "SELECT * FROM Place where map_id = :map_id  ", nativeQuery = true) // jpql
	Place getPlaceByMapID(@Param("map_id") int map_id);

	// update
	@Modifying
	@Query(value = "UPDATE Place SET title = :title , price = :price , area = :area , district_id = :district_id , ward_id = :ward_id , street_id = :street_id "
			+ ", address = :address , role_of_place_id = :role_of_place_id , frontispiece = :frontispiece , home_direction = :home_direction , floors = :floors "
			+ ", bed_rooms= :bed_rooms , toilets= :toilets ,  description= :description , contact_name = :contact_name "
			+ ", contact_address = :contact_address , contact_phone_number = :contact_phone_number , contact_email =:contact_email where place_id = :place_id ", nativeQuery = true) // jpql
	void updatePlace(@Param("title") String title, @Param("price") float price, @Param("area") float area,
			@Param("district_id") int district_id, @Param("ward_id") int wardID, @Param("street_id") int streetID,
			@Param("address") String address, @Param("role_of_place_id") int roleOfPlaceID,
			@Param("frontispiece") float frontispiece, @Param("home_direction") String home_direction,
			@Param("floors") int floors, @Param("bed_rooms") int bed_rooms, @Param("toilets") int toilets,
			@Param("description") String description, @Param("contact_name") String contactName,
			@Param("contact_phone_number") String contactPhoneNumber, @Param("contact_address") String contactAddress,
			@Param("contact_email") String contactEmail, @Param("place_id") int place_id);

	// change status

	@Modifying
	@Query(value = "UPDATE Place SET status_place_id =:status_place_id where place_id = :place_id ", nativeQuery = true) // jpql
	void changeStatusPlace(@Param("status_place_id") int statusPlaceID, @Param("place_id") int placeID);

	// get list place for manage post
	@Query(value = "SELECT * FROM Place where owner_id = :owner_id ", nativeQuery = true) // jpql
	List<Place> getListForManagePost(@Param("owner_id") int userID);

}
