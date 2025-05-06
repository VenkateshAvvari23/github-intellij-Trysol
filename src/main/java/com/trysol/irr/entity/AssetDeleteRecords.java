package com.trysol.irr.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "assetDeleteRecords")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetDeleteRecords {

    @Id
    @Column (name="EmployeeId")
    private long  employeeId;


    @Column(name="EmployeeName")
    private String employeeName;

    @Column(name="Department")
    private String department;

    @Column(name="AssignedDate")
    private String assignedDate;

    //    @Id
   //    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AssetId")
    private long assetId;


    @Column(name="AssetType")
    private  String assetType;

    @Column(name="Make")
    private String make;

    @Column(name="Processor")
    private String processor;


    @Column(name = "Ram")
    private String ram;


    @Column(name="HardDisk")
    private String hardDisk;

    @Column(name="Charger")
    private String charger;

    @Column(name="ChargerWatt")
    private String chargerWatt;

    @Column(name="Bag")
    private String bag;

    @Column(name="ModelNumber")
    private String modelNumber;

    @Column(name = "SerialNumber")
    private String serialNumber;


    @Column(name="IssuedItPersonName")
    private String issuedItPersonName;

    @Column(name="ApprovedBy")
    private String approvedBy;
}
