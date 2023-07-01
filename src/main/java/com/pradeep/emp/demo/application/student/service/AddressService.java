package com.pradeep.emp.demo.application.student.service;

import com.pradeep.emp.demo.application.student.models.StudentRequestPayload;
import com.pradeep.emp.demo.domain.entities.student.valueObjects.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    public Address getAddressDetails(StudentRequestPayload.Address addressDetails) {

        Address.PermanentAddress permanentAddress = new Address.PermanentAddress(addressDetails.permanentAddress.line1,
                addressDetails.permanentAddress.line2, addressDetails.permanentAddress.line3, addressDetails.permanentAddress.city,
                addressDetails.permanentAddress.zipCode, addressDetails.permanentAddress.state, addressDetails.permanentAddress.country);

        Address.CommunicationAddress communicationAddress = new Address.CommunicationAddress(addressDetails.communicationAddress.line1,
                addressDetails.communicationAddress.line2, addressDetails.communicationAddress.line3, addressDetails.communicationAddress.city,
                addressDetails.communicationAddress.zipCode, addressDetails.communicationAddress.state, addressDetails.communicationAddress.country);

        return new Address(permanentAddress, communicationAddress);
    }


}
