package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.ConsumptionStatisticsService;
import com.adgwr.online.ordering.system.mapper.CustomerMapper;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = false)
public class ConsumptionStatisticsImpl implements ConsumptionStatisticsService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<CustumerConsumption> getConsumptionWithScope(String cId, String scope) {
        if (scope.equals("all")) {
            return customerMapper.getConsumptions(cId);
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置时间格式
        return customerMapper.getConsumptionsWithScope(cId, getStartDateOfScope(scope), df.format(new Date()));
    }

    /**
     * 返回规定时间范围的起始时间
     * @param scope 时间范围 today week month
     * @return 范围的起始时间
     */
    private String getStartDateOfScope(String scope) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        String date = sdf.format(new Date());
        switch (scope) {
            case "today": {
                date = date + " 00:00:00";
                return date;
            }
            case "week": {
                Calendar cal = Calendar.getInstance();
                Date time;
                try {
                    time = sdf.parse(date);
                    cal.setTime(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
                int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
                if (1 == dayWeek) {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
                cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
                int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
                cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
                String mondayDate = sdf.format(cal.getTime());
                mondayDate = mondayDate + " 00:00:00";// startDate
                return mondayDate;
            }
            case "month": {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal = Calendar.getInstance();// 获取当前日期
                cal.add(Calendar.MONTH, 0);
                cal.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
                String firstDay = df.format(cal.getTime());
                firstDay = firstDay + " 00:00:00";// startDate
                return firstDay;
            }
            default:
                throw new IllegalArgumentException("范围错误！");
        }
    }
}
