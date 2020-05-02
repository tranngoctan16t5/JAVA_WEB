package com.codegym.demo.controller;

import com.codegym.demo.model.*;
import com.codegym.demo.repository.*;
import com.codegym.demo.service.ContractService;
import com.codegym.demo.service.CustomerService;
import com.codegym.demo.service.EmployeeService;
import com.codegym.demo.service.ServiceService;
import com.codegym.demo.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;
import javax.servlet.http.Cookie;

@Controller
@SessionAttributes("favoriteService")
public class MainController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    TypeCustomerRepository typeCustomerRepository;
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ContractDetailRepository contractDetailRepository;
    @Autowired
    AccompanyServiceRepository accompanyServiceRepository;

    @ModelAttribute("customers")
    private List<Customer> customers() {
        return customerService.findAll();
    }

    @ModelAttribute("TypeCustomers")
    private List<TypeCustomer> typeCustomers() {
        return typeCustomerRepository.getAll();
    }

    @ModelAttribute("ServiceTypes")
    private List<ServiceType> serviceTypes() {
        return serviceTypeRepository.findAll();
    }

    @ModelAttribute("rentTypes")
    private List<RentType> rentTypes() {
        return rentTypeRepository.findAll();
    }

    @ModelAttribute("services")
    private Page<Service> services(Pageable pageable) {
        return serviceService.findAll(pageable);
    }

    @ModelAttribute("employees")
    private Page<Employee> employees(Pageable pageable) {
        return employeeService.findAll(pageable);
    }

    @ModelAttribute("accompanyServices")
    private List<AccompanyService> accompanyServices() {
        return accompanyServiceRepository.myFindAll();
    }

    @ModelAttribute("favoriteService")
    private Set<Service> favServices() {
        return new HashSet<>();
    }

    @ModelAttribute("contracts")
    private Page<Contract> contracts(Pageable pageable) {
        return contractService.findAll(pageable);
    }


    @GetMapping("/create-customer")
    public ModelAndView creatFormCustomer() {
        return new ModelAndView("customer/create", "customer", new Customer());
    }

    @PostMapping("/create-customer")
    public String createCustomer(@Valid Customer customer, BindingResult result, RedirectAttributes redirectAttributes) {
        new CustomerValidator().validate(customer, result);
        if (result.hasFieldErrors()) {
            return "customer/create";
        } else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Create Customer Successfully !!!");
            return "redirect:/list-customer";
        }

    }

    @GetMapping("/list-customer")
    public ModelAndView listCustomer(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                     @RequestParam(name = "size", required = false, defaultValue = "5") int size,
                                     @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                     @RequestParam(name = "sortValue", required = false, defaultValue = "fullName") String sortValue,
                                     Pageable pageable, Sort sortable) {
        if (sort.equals("ASC")) {
            if (sortable.isSorted()) {
                sortable = Sort.by(sortValue).descending();
            } else {
                sortable = Sort.by(sortValue).ascending();
            }
        }
        if (sort.equals("DESC")) {
            if (sortable.isSorted()) {
                sortable = Sort.by(sortValue).ascending();
            } else {
                sortable = Sort.by(sortValue).descending();
            }
        }
        pageable = PageRequest.of(page, size, sortable);
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customerService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/")
    public String homeDisplay() {
        return "home";
    }

    @GetMapping("/delete-customer/{id}")
    public String confirmDelete(Model model, @PathVariable String id) {
        model.addAttribute("customerId", id);
        return "customer/delete_confirm";
    }

    @PostMapping("/delete-customer/{id}")
    public String deleteCustomer(@RequestParam String confirm, RedirectAttributes redirectAttributes, @PathVariable String id) {
        if (confirm.equals("yes")) {
            customerService.remove(id);
            redirectAttributes.addFlashAttribute("message", "Delete Customer successfully !!!");
            return "redirect:/list-customer";
        }
        return "redirect:/list-customer";
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView formEditCustomer(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/edit-customer")
    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit Customer successfully !!!");
        return "redirect:/list-customer";
    }

    @GetMapping("/customer-search")
    public String searchCustomer(@RequestParam("customerName") String name, Model model, Pageable pageable) {
        pageable = PageRequest.of(0, 5);
        model.addAttribute("customers", customerService.findByFullName(name, pageable));
        return "customer/list";
    }

    @GetMapping("/list-service")
    public String displayService(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "sortValue", required = false, defaultValue = "area") String sortValue,
            Model model, Pageable pageable, Sort sortable
    ) {
        if (sort.equals("ASC")) {
            if (sortable.isSorted()) {
                sortable = Sort.by(sortValue).descending();
            } else {
                sortable = Sort.by(sortValue).ascending();
            }
        }
        if (sort.equals("DESC")) {
            if (sortable.isSorted()) {
                sortable = Sort.by(sortValue).ascending();
            } else {
                sortable = Sort.by(sortValue).descending();
            }
        }
        pageable = PageRequest.of(page, size, sortable);
        model.addAttribute("services", serviceService.findAll(pageable));
        return "service/list";
    }

    @GetMapping("/create-service")
    public ModelAndView formCreateService() {
        return new ModelAndView("service/create", "service", new Service());
    }

    @PostMapping("/create-service")
    public String createService(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Create Service Successfully!!!");
        return "redirect:/list-service";
    }

    @GetMapping("/edit-service/{id}")
    public ModelAndView formUpdateService(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("service/edit", "service", serviceService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit-service")
    public String handleUpdateService(Service service, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Updated successfully!");
        return "redirect:/list-service";
    }

    @GetMapping("/delete-service/{id}")
    public String confirmDeleteService(Model model, @PathVariable Long id) {
        model.addAttribute("serviceId", id);
        return "service/delete_confirm";
    }

    @PostMapping("/delete-service/{id}")
    public String deleteService(@RequestParam String confirm, RedirectAttributes redirectAttributes, @PathVariable Long id) {
        if (confirm.equals("yes")) {
            serviceService.remove(id);
            redirectAttributes.addFlashAttribute("message", "Delete Customer successfully !!!");
            return "redirect:/list-service";
        }
        return "redirect:/list-service";
    }

    @GetMapping("/create-contract")
    public ModelAndView handleNewContract() {
        return new ModelAndView("contract/create", "contract", new Contract());
    }

    @PostMapping("/create-contract")
    public String handleSaveContract(@ModelAttribute Contract contract, HttpServletResponse response,
                                     @CookieValue(value = "dateHistoryCreated", defaultValue = "")
                                             String dateHistoryCreated) {
        contractService.save(contract);
        LocalDate today = LocalDate.now();
        dateHistoryCreated += "#" + today.toString();

        Cookie cookie = new Cookie("dateHistoryCreated", dateHistoryCreated);
        cookie.setMaxAge(5 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/";
    }

    @GetMapping("/create-contract-detail")
    public ModelAndView handleNewDetailContract() {
        return new ModelAndView("contractDetail/create", "contractDetail", new ContractDetail());
    }

    @PostMapping("/create-contract-detail")
    public String handleSaveDetailContract(@ModelAttribute ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
        return "redirect:/";
    }

    @GetMapping("/customer-using-service")
    public ModelAndView handleCustomerUsingContract(Pageable pageable,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "5") int size) {
        pageable = PageRequest.of(page, size);
        return new ModelAndView("customer/customer-using-service",
                "customers", customerService.findCustomersUsingService(pageable));
    }

    @GetMapping("user_home")
    public String userHome() {
        return "user_home";
    }

    @GetMapping("/user/list-service")
    public ModelAndView userListService() {
        return new ModelAndView("user_page/display_service");
    }

    @GetMapping("/fav-service/{id}")
    public String handleLikeService(@PathVariable Long id,
                                    @ModelAttribute("favoriteService") Set<Service> favServices,
                                    RedirectAttributes redirectAttributes) {
        for (Service service : favServices) {
            if (service.getId() == id) {
                redirectAttributes.addFlashAttribute("message", "Đã thích rồi nên k cần thích nữa");
                return "redirect:/user/list-service";
            }
        }

        favServices.add(serviceService.findById(id));
        redirectAttributes.addFlashAttribute("message", "Added to collections!");
        return "redirect:/user/list-service";
    }

    @GetMapping("/user/fav-service")
    public String favService() {
        return "user_page/favorite-service";
    }

    @GetMapping("/history-contract")
    public String displayHistoryContract(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("dateHistoryCreated")) {
                StringBuilder formatted = new StringBuilder();
                Arrays.asList(c.getValue().split("#")).forEach(s -> {
                    if (!s.equals("")) {
                        formatted.append("#").append(s).append("<br>");
                    }
                });
                model.addAttribute("dateHistoryCreated", formatted);
            }
        }
        return "customer/history_contract";
    }


}

