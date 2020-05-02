package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;

    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    private double area;
    @Column(name = "floor_amount")
    private int floorAmount;
    @Column(name = "maximum_people")
    private int maximumPeople;
    @Column(name = "rent_cost")
    private long rentCost;
    @Column(name = "room_standard")
    private String roomStandard;
    @Column(name = "other_convenience_description")
    private String otherConvenienceDescription;
    @Column(name = "free_accompany_service")
    private String freeAccompanyService;

    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;
    private String status;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contracts;
    public Service() {
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloorAmount() {
        return floorAmount;
    }

    public void setFloorAmount(int floorAmount) {
        this.floorAmount = floorAmount;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public long getRentCost() {
        return rentCost;
    }

    public void setRentCost(long rentCost) {
        this.rentCost = rentCost;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherConvenienceDescription() {
        return otherConvenienceDescription;
    }

    public void setOtherConvenienceDescription(String otherConvenienceDescription) {
        this.otherConvenienceDescription = otherConvenienceDescription;
    }

    public String getFreeAccompanyService() {
        return freeAccompanyService;
    }

    public void setFreeAccompanyService(String freeAccompanyService) {
        this.freeAccompanyService = freeAccompanyService;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
