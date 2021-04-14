package com.epam.automation.model;

import java.util.Objects;

public class VirtualMachine {

    private String section;
    private String numberOfInstances;
    private String operatingSystemSoftware;
    private String vmClass;
    private String series;
    private String machineType;
    private String numberOfGpus;
    private String gpuType;
    private String localSsd;
    private String datacenterLocation;
    private String committedUsage;

    public VirtualMachine(String section, String numberOfInstances, String operatingSystemSoftware, String vmClass, String series, String machineType, String numberOfGpus, String gpuType, String localSsd, String datacenterLocation, String committedUsage) {
        this.section = section;
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemSoftware = operatingSystemSoftware;
        this.vmClass = vmClass;
        this.series = series;
        this.machineType = machineType;
        this.numberOfGpus = numberOfGpus;
        this.gpuType = gpuType;
        this.localSsd = localSsd;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystemSoftware() {
        return operatingSystemSoftware;
    }

    public void setOperatingSystemSoftware(String operatingSystemSoftware) {
        this.operatingSystemSoftware = operatingSystemSoftware;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGpus() {
        return numberOfGpus;
    }

    public void setNumberOfGpus(String numberOfGpus) {
        this.numberOfGpus = numberOfGpus;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "VirtualMachine{" +
                "section='" + section + '\'' +
                ", numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystemSoftware='" + operatingSystemSoftware + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGpus='" + numberOfGpus + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualMachine that = (VirtualMachine) o;
        return Objects.equals(section, that.section) && Objects.equals(numberOfInstances, that.numberOfInstances) && Objects.equals(operatingSystemSoftware, that.operatingSystemSoftware) && Objects.equals(vmClass, that.vmClass) && Objects.equals(series, that.series) && Objects.equals(machineType, that.machineType) && Objects.equals(numberOfGpus, that.numberOfGpus) && Objects.equals(gpuType, that.gpuType) && Objects.equals(localSsd, that.localSsd) && Objects.equals(datacenterLocation, that.datacenterLocation) && Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section, numberOfInstances, operatingSystemSoftware, vmClass, series, machineType, numberOfGpus, gpuType, localSsd, datacenterLocation, committedUsage);
    }
}
