package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.ReceiverService;
import com.adgwr.online.ordering.system.domain.Receiver;
import com.adgwr.online.ordering.system.mapper.ReceiverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
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
        Receiver receiver = new Receiver();
        receiver.setrId(rId);
        receiver.setIsshow(new Byte("0"));
        receiverMapper.updateByPrimaryKeySelective(receiver);
    }

    @Override
    public Receiver getReceiverById(int rId) {
        return  receiverMapper.selectByPrimaryKey(rId);
    }

    @Override
    public void modifyReceiver(int rId, String rName, String address, String rTel) {
        Receiver receiver = new Receiver();
        receiver.setrId(rId);
        receiver.setrName(rName);
        receiver.setAddress(address);
        receiver.setrTel(rTel);
        receiverMapper.updateByPrimaryKeySelective(receiver);
    }

    @Override
    public List<Receiver> getReceivers(String cId) {
        Example example = new Example(Receiver.class);
        example.createCriteria().andEqualTo("cId", cId).andEqualTo("isshow", 1);
        return receiverMapper.selectByExample(example);
    }
}
