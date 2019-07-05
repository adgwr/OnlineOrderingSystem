package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.ReceiverService;
import com.adgwr.online.ordering.system.domain.Receiver;
import com.adgwr.online.ordering.system.mapper.ReceiverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    private ReceiverMapper receiverMapper;


    @Override
    public void addReceiver(String cId, String rName, String address, String rTel) {
        Receiver receiver = new Receiver();
        receiver.setcId(cId);
        receiver.setrName(rName);
        receiver.setAddress(address);
        receiver.setrTel(rTel);
        receiver.setIsshow(new Byte("1"));
        receiverMapper.insert(receiver);
    }

    @Override
    public void deleteReceiver(int rId) {

    }

    @Override
    public void findReceiverById(int rId) {

    }

    @Override
    public List<Receiver> getReceivers(String cId) {
        Example example = new Example(Receiver.class);
        example.createCriteria().andEqualTo("cId", cId).andEqualTo("isshow", 1);
        return receiverMapper.selectByExample(example);
    }
}
