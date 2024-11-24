package com.carelon.premiumcalculation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.carelon.premiumcalculation.dto.Rates;
import com.carelon.premiumcalculation.entity.RatesEntity;
import com.carelon.premiumcalculation.repository.RatesRepository;

import lombok.Data;

@Service
@Data
public class RatesService {

    private final RatesRepository ratesRepository;
    private final ModelMapper mapper;

    public List<Rates> getRates() {
        List<RatesEntity> ratesEntities = ratesRepository.findAll();
        return ratesEntities.stream().map(rate -> mapper.map(rate, Rates.class)).collect(Collectors.toList());
    }

    public Rates addRate(Rates rate) {
        RatesEntity ratesEntity = mapper.map(rate, RatesEntity.class);
        return mapper.map(ratesRepository.save(ratesEntity), Rates.class);
    }

    public Rates updateRate(String age,Rates rate) {
        RatesEntity ratesEntity = mapper.map(rate, RatesEntity.class);
        ratesEntity.setAge(age);
        return mapper.map(ratesRepository.save(ratesEntity), Rates.class);
    }

    public void deleteRate(String age){
        ratesRepository.deleteById(age);;
    }
}
