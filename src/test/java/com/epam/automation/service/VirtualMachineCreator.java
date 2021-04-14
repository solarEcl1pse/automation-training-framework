package com.epam.automation.service;

import com.epam.automation.model.VirtualMachine;

public class VirtualMachineCreator {

    private static final String TESTDATA_SECTION = "testdata.section";
    private static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.number.of.instances";
    private static final String TESTDATA_OPERATING_SYSTEM_SOFTWARE = "testdata.operating.system.software";
    private static final String TESTDATA_VM_CLASS = "testdata.vm.class";
    private static final String TESTDATA_SERIES = "testdata.series";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    private static final String TESTDATA_NUMBER_OF_GPUS = "testdata.number.of.gpus";
    private static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";
    private static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    private static final String TESTDATA_DATACENTER_LOCATION = "testdata.datacenter.location";
    private static final String TESTDATA_COMMITTED_USAGE = "testdata.committed.usage";

    public static VirtualMachine withParametersFromProperty() {
        return new VirtualMachine(TestDataReader.getTestData(TESTDATA_SECTION),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM_SOFTWARE),
                TestDataReader.getTestData(TESTDATA_VM_CLASS),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }
}
