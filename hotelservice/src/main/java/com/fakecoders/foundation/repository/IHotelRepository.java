package com.fakecoders.foundation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fakecoders.foundation.entities.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, String> {

}
