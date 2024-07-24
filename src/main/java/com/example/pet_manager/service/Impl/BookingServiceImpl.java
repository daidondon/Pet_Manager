package com.example.pet_manager.service.Impl;

import com.example.pet_manager.dto.BookingDto;
import com.example.pet_manager.dto.CustomerDto;
import com.example.pet_manager.entity.Booking;
import com.example.pet_manager.entity.Customer;
import com.example.pet_manager.entity.Pet;
import com.example.pet_manager.exception.APIException;
import com.example.pet_manager.repository.BookingRepository;
import com.example.pet_manager.request.BookingRequest;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    @Transactional
    public EntityCustomResponse getAll(Integer doctorId) {
        List<Booking> listBooking = bookingRepository.findByDoctorIdOrderByCheckInDesc(doctorId);
        List<BookingDto> listBookingDto = listBooking.stream().map(booking ->{

            BookingDto bookingDto = modelMapper.map(booking, BookingDto.class);
            Customer customer= booking.getCustomer();
            booking.getCustomer();
            CustomerDto customerDto=modelMapper.map(customer, CustomerDto.class);
            customerDto.setUser(null);
            customerDto.setCustomerName(booking.getCustomer().getUser().getFull_name());
            customerDto.setCustomerGmail(booking.getCustomer().getUser().getGmail());
            customerDto.setCustomerPhone(booking.getCustomer().getUser().getPhone_number());
            bookingDto.setCustomerDto(customerDto);
            return bookingDto;
        }).collect(Collectors.toList());

        return new EntityCustomResponse(1, "List Booking", 200, listBookingDto);
    }

    @Override
    @Transactional
    public EntityCustomResponse addBooking(BookingRequest bookingRequest) {
        Customer customer= new Customer();
        Booking booking= new Booking();
        customer.setId(bookingRequest.getCustomerId());
        booking.setCustomer(customer);
        booking.setDoctorId(bookingRequest.getDoctorId());
        booking.setContent(bookingRequest.getContent());
        booking.setCheckIn(bookingRequest.getCheckIn());
        booking.setCheckOut(bookingRequest.getCheckOut());


        Booking bookingDb = bookingRepository.save(booking);
        if (ObjectUtils.isEmpty(bookingDb)) {
            //TODO : exception handler
        }

        return new EntityCustomResponse(1, "Add Booking Success", 200, bookingDb);

    }

    @Override
    @Transactional
    public EntityCustomResponse updateBooking(Integer bookingId, Integer status) {
        if (ObjectUtils.isEmpty(bookingId)) {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "Id không được để trống");
        }
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "không tìm thấy booking"));
        booking.setStatus(status);

        Booking bookingDb = bookingRepository.save(booking);
        if (ObjectUtils.isEmpty(bookingDb)) {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "update booking thất bại");
        }

        return new EntityCustomResponse(1, "Update Booking Success", 200, null);
    }
}
