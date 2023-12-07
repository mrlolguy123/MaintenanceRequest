package com.example.maintenancerequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAllByApartmentNumber(Integer apartmentNumber) { return requestRepository.findAllByApartmentnumberEquals(apartmentNumber); }
    public List<Request> getAllByArea(String area) { return requestRepository.findAllByAreaEquals(area); }
    public List<Request> getAllByDate(String date) { return requestRepository.findAllByFulldatetimeContaining(date); }
    public List<Request> getAllByState(String status) {
        boolean condition = false;
        if(status.equalsIgnoreCase("completed"))
            condition = true;
        return requestRepository.findAllByCompletedEquals(condition);
    }

    public Request getById(Integer id) {
        return requestRepository.findById(id).orElse(null);
    }

    public List<Request> getAllRequests() { return requestRepository.findAllByOrderByFulldatetimeDesc(); }

    public void toggleCompletion(Integer id) {
        Request r = getById(id);
        if(r != null) {
            r.setCompleted(r.isCompleted());
            requestRepository.save(r);
        }
    }

    public void addRequest(Integer apartmentNumber, String area, String desc, String img)
    {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        String dateString = currentDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String timeString = currentTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        String datetime = dateString + " " + timeString;
        Request r = new Request(apartmentNumber, area, desc, datetime, img, false);
        requestRepository.save(r);
    }


}
