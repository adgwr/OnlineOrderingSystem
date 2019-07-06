# 更新
实现了订单管理、收藏、评价以及部分客户端统计的功能
实现了订单、菜品、收藏、评论页面的分页
# 分页
单表查询可以使用pageHelper，后端详见MenuController，前端详见menu.html
多表查询pageHelper似乎失效了，采用从数据库中全部查出数据后再进行分页，详见OrderController和orderList.html