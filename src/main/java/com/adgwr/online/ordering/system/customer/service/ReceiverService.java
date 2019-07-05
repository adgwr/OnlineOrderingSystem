package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Receiver;

import java.util.List;

public interface ReceiverService {

    void addReceiver(String cId, String rName, String address, String rTel);

    void deleteReceiver(int rId);

    void findReceiverById(int rId);

    List<Receiver> getReceivers(String cId);

}
