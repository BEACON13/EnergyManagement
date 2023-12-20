package com.example.energymanagement.service;

import com.example.energymanagement.model.domain.Device;
import com.example.energymanagement.model.domain.Event;
import com.example.energymanagement.model.vo.EnergyDailyUseVO;
import com.example.energymanagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private DeviceService deviceService;

    public List<EnergyDailyUseVO> listEnergyDailyUseByTid(Integer sid, LocalDate startDate, LocalDate endDate) {
        List<Integer> ids = deviceService.listDeviceBySid(sid).stream().map(Device::getDid).toList();
        List<List<Event>> events = new ArrayList<>();
        for (Integer id : ids) {
            List<Event> eventList = eventRepository.listEventByDate(startDate, endDate, id);
            events.add(eventList);
        }
        List<EnergyDailyUseVO> energyDailyUseVOS = new ArrayList<>();

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            double energyUse = 0;
            for (List<Event> event : events) {
                for (Event e : event) {
                    if (e.getTime().toLocalDate().equals(date)) {
                        energyUse += e.getValue();
                    }
                }
            }
            EnergyDailyUseVO energyDailyUseVO = new EnergyDailyUseVO();
            energyDailyUseVO.setDate(date);
            energyDailyUseVO.setEnergyUse(energyUse);
            energyDailyUseVOS.add(energyDailyUseVO);
        }
        return energyDailyUseVOS;
    }
}
