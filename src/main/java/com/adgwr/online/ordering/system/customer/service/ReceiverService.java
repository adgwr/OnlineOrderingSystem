package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Receiver;

import java.util.List;

public interface ReceiverService {

    void addReceiver(String cId, String rName, String address, String rTel);

    void deleteReceiver(int rId);

    Receiver getReceiverById(int rId);

    void modifyReceiver(int rId, String rName, String address, String rTel);

    List<Receiver> getReceivers(String cId);

}
