package com.example.maintenancerequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class IndexController {
    private final RequestService requestService;
    private final PersonService personService;

    public IndexController(RequestService requestService, PersonService personService) {
        this.requestService = requestService;
        this.personService = personService;
    }

    // **********************************  HOME **********************************
    @GetMapping("")
    public String home(Model model)
    {
        return "home";
    }

    @GetMapping("/tenant")
    public String tenant(Model model)
    {
        return "tenant";
    }

    @GetMapping("/member")
    public String member(Model model)
    {
        List<Request> requestList = requestService.getAllRequests();
        model.addAttribute("requestList", requestList);
        return "member";
    }

    @GetMapping("/manager")
    public String manager(Model model)
    {
        List<Person> personList = personService.getAllPersonnel();
        model.addAttribute("personList", personList);
        return "manager";
    }

    // ********************************** TENANT VIEW **********************************

    @PostMapping("/tenant/addRequest")
    public String addRequestSubmit(Model model, @RequestParam String email, @RequestParam Integer apartmentNumber, @RequestParam String area, @RequestParam String desc, @RequestParam String img)
    {
        Person p = personService.findByEmail(email);
        Integer pNumber = p.getApartmentnumber();
        if(!Objects.equals(pNumber, apartmentNumber))
            return "home";;
        if(img.isEmpty())
            img = null;
        requestService.addRequest(apartmentNumber, area, desc, img);
        return "home";
    }

    // ********************************** MEMBER VIEW **********************************

    @GetMapping("/member/toggle/{id}")
    public String toggleCompletion(Model model, @PathVariable Integer id)
    {
        requestService.toggleCompletion(id);
        model.addAttribute("completed", requestService.getById(id).isCompleted());
        List<Request> requestList = requestService.getAllRequests();
        model.addAttribute("requestList", requestList);
        return "member";
    }

    @PostMapping("/member/search")
    public String search(Model model, @RequestParam(name = "apartmentnumbersearch", required = false) Integer apartmentnumber, @RequestParam(name = "areasearch", required = false) String area, @RequestParam(name = "datesearch", required = false) String date, @RequestParam(name = "statussearch", required = false) String status)
    {
        List<Request> requestList = requestService.getAllRequests();

        if(!status.isEmpty()) { requestList = requestService.getAllByState(status); }
        if(!date.isEmpty()) { requestList = requestService.getAllByDate(date); }
        if(!area.isEmpty()) { requestList = requestService.getAllByArea(area); }
        if(apartmentnumber != null) { requestList = requestService.getAllByApartmentNumber(apartmentnumber); }

        model.addAttribute("requestList", requestList);
        return "member";
    }

    // ********************************** MANAGER VIEW **********************************

    @GetMapping("/manager/delete/{id}")
    public String deletePerson(Model model, @PathVariable Integer id)
    {
        personService.deletePerson(id);
        List<Person> personList = personService.getAllPersonnel();
        model.addAttribute("personList", personList);
        return "manager";
    }

    @PostMapping("/manager/add")
    public String addPersonSubmit(Model model, @RequestParam(name = "personname") String name, @RequestParam(name = "apartmentnumber") Integer apt, @RequestParam(name = "phonenumber") String phone, @RequestParam(name = "email") String email, @RequestParam(name = "checkin") String checkin, @RequestParam(name = "checkout") String checkout)
    {
        personService.addPerson(name,apt,phone,email,checkin,checkout);
        List<Person> personList = personService.getAllPersonnel();
        model.addAttribute("personList", personList);
        return "manager";
    }

    @PostMapping("/manager/edit")
    public String editPerson(Model model, @RequestParam(name = "personid") Integer id, @RequestParam(name = "editApt") Integer apt)
    {
        personService.updateApartment(id,apt);
        List<Person> personList = personService.getAllPersonnel();
        model.addAttribute("personList", personList);
        return "manager";
    }
}
