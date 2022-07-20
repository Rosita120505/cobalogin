package com.rositasrs.cobalogin.controller;


import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.PaymentMethodDto;
import com.rositasrs.cobalogin.model.entity.PaymentMethod;
import com.rositasrs.cobalogin.repository.PaymentMethodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentMethodController {
    private final PaymentMethodRepository paymentMethodRepository;
    public PaymentMethodController (PaymentMethodRepository paymentMethodRepository){
        this.paymentMethodRepository = paymentMethodRepository;
    }
    @GetMapping("/bayar")
    public List<PaymentMethodDto> getListPaymentMethod(){
        List<PaymentMethodDto> list = new ArrayList<>();
        for(PaymentMethod pm : paymentMethodRepository.findAll()){
            list.add(convertEntityToDto(pm));
        }
        return list;
    }
    @PostMapping("/save")
    public DefaultResponse<PaymentMethodDto>savePaymentMethod(@RequestBody PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = convertDtoToEntity(paymentMethodDto);
        DefaultResponse<PaymentMethodDto> response = new DefaultResponse<>();
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findBypaymentId(paymentMethodDto.getPaymentId());
        if (optionalPaymentMethod.isPresent()) {
            response.setMessage("Gagal menyimpan pembayaran");
        } else {
            paymentMethodRepository.save(paymentMethod);
            response.setMessage("Pembayaran Berhasil");
            response.setData(paymentMethodDto);
        }
        return response;
    }
    public PaymentMethod convertDtoToEntity(PaymentMethodDto dto){
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentId(dto.getPaymentId());
        paymentMethod.setDescription(dto.getDescription());

        return paymentMethod;
    }
    public PaymentMethodDto convertEntityToDto(PaymentMethod entity){
        PaymentMethodDto dto = new PaymentMethodDto();
        dto.setPaymentId(entity.getPaymentId());
        dto.setDescription(entity.getDescription());

        return dto;
    }
}
