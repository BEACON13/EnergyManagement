package com.example.energymanagement.service;

import com.example.energymanagement.model.domain.Device;
import com.example.energymanagement.model.domain.EnergyPrice;
import com.example.energymanagement.model.domain.Event;
import com.example.energymanagement.model.vo.EnergyBillVO;
import com.example.energymanagement.model.vo.EnergyDailyUseVO;
import com.example.energymanagement.repository.EnergyPriceRepository;
import com.example.energymanagement.repository.EventRepository;
import com.example.energymanagement.repository.ServiceLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private EnergyPriceRepository energyPriceRepository;

    @Autowired
    private ServiceLocationRepository serviceLocationRepository;

    public List<EnergyDailyUseVO> listEnergyDailyUseBySid(Integer sid, LocalDate startDate, LocalDate endDate) {
        List<Event> events = listEnergyUseEventBySid(sid, startDate, endDate);
        List<EnergyDailyUseVO> energyDailyUseVOS = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            double energyUse = 0;
            Iterator<Event> iterator = events.iterator();
            while (iterator.hasNext()) {
                Event event = iterator.next();
                if (event.getTime().toLocalDate().equals(date)) {
                    energyUse += event.getValue();
                    iterator.remove();
                }
            }
            EnergyDailyUseVO energyDailyUseVO = new EnergyDailyUseVO();
            energyDailyUseVO.setDate(date);
            energyDailyUseVO.setEnergyUse(energyUse);
            energyDailyUseVOS.add(energyDailyUseVO);
        }
        return energyDailyUseVOS;
    }

    public List<EnergyDailyUseVO> listEnergyTimeUseBySid(Integer sid, LocalDate startDate) {
        List<Event> events = listEnergyUseEventBySid(sid, startDate, startDate);
        List<EnergyDailyUseVO> energyDailyUseVOS = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            double energyUse = 0;
            Iterator<Event> iterator = events.iterator();
            while (iterator.hasNext()) {
                Event event = iterator.next();
                if (event.getTime().toLocalTime().getHour() == i) {
                    energyUse += event.getValue();
                    iterator.remove();
                }
            }
            EnergyDailyUseVO energyDailyUseVO = new EnergyDailyUseVO();
            energyDailyUseVO.setEnergyUse(energyUse);
            energyDailyUseVOS.add(energyDailyUseVO);
        }
        return energyDailyUseVOS;
    }

    public List<EnergyBillVO> listEnergyBillBySid(Integer sid, LocalDate startDate, LocalDate endDate) {
        String zipcode = serviceLocationRepository.getZipcodeBySid(sid);
        List<EnergyPrice> energyPrices = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            List<EnergyPrice> energyPriceByDate = energyPriceRepository.getEnergyPriceByDate(date, zipcode);
            energyPrices.addAll(energyPriceByDate);
        }
        List<EnergyPrice> collect = energyPrices.stream().distinct().collect(Collectors.toList());
        List<Event> events = listEnergyUseEventBySid(sid, startDate, endDate);
        return getEnergyBillVOS(startDate, endDate, collect, events);
    }

    public List<EnergyBillVO> listEnergyBillByDid(Integer sid, Integer did, LocalDate startDate, LocalDate endDate) {
        String zipcode = serviceLocationRepository.getZipcodeBySid(sid);
        List<EnergyPrice> energyPrices = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            List<EnergyPrice> energyPriceByDate = energyPriceRepository.getEnergyPriceByDate(date, zipcode);
            energyPrices.addAll(energyPriceByDate);
        }
        List<EnergyPrice> collect = energyPrices.stream().distinct().collect(Collectors.toList());
        List<Event> events = eventRepository.listEnergyUseEventByDate(startDate, endDate, did);
        return getEnergyBillVOS(startDate, endDate, collect, events);
    }

    private List<EnergyBillVO> getEnergyBillVOS(LocalDate startDate, LocalDate endDate, List<EnergyPrice> prices, List<Event> events) {
        List<EnergyBillVO> energyBillVOS = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            double price = 0;
            Iterator<Event> iterator = events.iterator();
            while (iterator.hasNext()) {
                Event event = iterator.next();
                if (event.getTime().toLocalDate().equals(date)) {
                    price += getBill(event, prices);
                    iterator.remove();
                }
            }
            EnergyBillVO energyBillVO = new EnergyBillVO();
            energyBillVO.setDate(date);
            energyBillVO.setEnergyBill(price);
            energyBillVOS.add(energyBillVO);
        }
        return energyBillVOS;
    }

    public Double getBill(Event event, List<EnergyPrice> energyPrices) {
        double bill = 0;
        for (EnergyPrice energyPrice : energyPrices) {
            if (event.getTime().isAfter(energyPrice.getStartTime()) && event.getTime().isBefore(energyPrice.getEndTime())) {
                bill = event.getValue() * energyPrice.getPrice();
                break;
            }
        }
        return bill;
    }

    public List<Event> listEnergyUseEventBySid(Integer sid, LocalDate startDate, LocalDate endDate) {
        List<Integer> ids = deviceService.listDeviceBySid(sid).stream().map(Device::getDid).toList();
        List<Event> events = new ArrayList<>();
        for (Integer id : ids) {
            List<Event> eventList = eventRepository.listEnergyUseEventByDate(startDate, endDate, id);
            events.addAll(eventList);
        }
        return events;
    }
}
