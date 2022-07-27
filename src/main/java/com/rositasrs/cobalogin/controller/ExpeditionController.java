package com.rositasrs.cobalogin.controller;


import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.dto.ExpeditionDto;
import com.rositasrs.cobalogin.model.entity.Expedition;
import com.rositasrs.cobalogin.repository.ExpeditionRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/expedition")
public class ExpeditionController {

    private ExpeditionRepository expeditionRepository;

    public ExpeditionController(ExpeditionRepository expeditionRepository) {
        this.expeditionRepository = expeditionRepository;
    }

    @PostMapping("/add") //add jasa ekspedisi
    public DefaultResponse <ExpeditionDto> saveExpedition (@RequestBody ExpeditionDto expeditionDto) {
        Expedition expedition = convertDtoToEntity(expeditionDto);
        DefaultResponse <ExpeditionDto> response = new DefaultResponse<>();
        Optional <Expedition> optional = expeditionRepository.findByDeliveryCode(expeditionDto.getDeliveryCode());
        if (optional.isPresent()) {
            response.setStatus(Boolean.FALSE);
            response.setMessage("Gagal Menyimpan, Jasa Ekspedisi Telah Tersedia");
        } else {
            expeditionRepository.save(expedition);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Jasa Ekspedisi Berhasil Ditambahkan");
            response.setData(expeditionDto);
        }
        return response;
    }

    public Expedition convertDtoToEntity(ExpeditionDto expeditionDto) {
        Expedition expedition = new Expedition();
        expedition.setDeliveryCode(expeditionDto.getDeliveryCode());
        expedition.setDescr(expeditionDto.getDescr());

        return expedition;
    }
}
