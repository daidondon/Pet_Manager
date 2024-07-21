package com.example.pet_manager.service;

import com.example.pet_manager.request.BookingRequest;
import com.example.pet_manager.response.EntityCustomResponse;

public interface BookingService {

    EntityCustomResponse getAll(Integer doctorId);

    EntityCustomResponse addBooking(BookingRequest bookingRequest);

    EntityCustomResponse updateBooking(Integer bookingId, Integer status);

}
