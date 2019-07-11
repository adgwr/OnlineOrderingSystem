package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Receiver;

import java.util.List;

public interface ReceiverService {

    /**
     * 添加收货人信息
     * @param cId 用户id
     * @param rName 收货人姓名
     * @param address 收货人的地址
     * @param rTel 收货人的电话
     */
    void addReceiver(String cId, String rName, String address, String rTel);

    /**
     * 通过收货人id删除收货人信息
     * @param rId 收货人id
     */
    void deleteReceiver(int rId);

    /**
     * 通过收货人id得到收货人信息
     * @param rId
     * @return
     */
    Receiver getReceiverById(int rId);

    /**
     * 通过收货人id来修改收货人信息
     * @param rId 收货人id
     * @param rName 收货人新的名字
     * @param address 收货人新的收货地址
     * @param rTel 收货人新的电话
     */
    void modifyReceiver(int rId, String rName, String address, String rTel);

    /**
     * 得到用户id下面关联的所有收货人信息
     * @param cId 用户id
     * @return 收货人信息对象列表
     */
    List<Receiver> getReceivers(String cId);

}
