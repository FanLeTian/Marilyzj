package com.abc.marilyzj.beans;

import java.util.List;

/**
 * Created by acer on 2017/5/16.
 */

public class OderListBean extends StatusBean {

    /**
     * obj : {"obj":{"orderListType":"1","userId":"1","reslut":[{"order":{"orderId":"1","deptId":"1","userName":"1","orderName":"1","payStatus":"true","price":100},"repairItems":{"repairItemsId":"1","repairName":"常规保养","price":"1233"}},{"order":{"orderId":"2","deptId":"2","userName":"2","orderName":"3","payStatus":"true","price":200},"repairItems":{"repairItemsId":"3","repairName":"机修","price":"341"}},{"order":{"orderId":"3","deptId":"3","userName":"3","orderName":"4","payStatus":"true","price":300},"repairItems":{"repairItemsId":"2","repairName":"大型保养","price":"3123"}}]}}
     */

    private ObjBeanX obj;

    public ObjBeanX getObj() {
        return obj;
    }

    public void setObj(ObjBeanX obj) {
        this.obj = obj;
    }

    public static class ObjBeanX {
        /**
         * obj : {"orderListType":"1","userId":"1","reslut":[{"order":{"orderId":"1","deptId":"1","userName":"1","orderName":"1","payStatus":"true","price":100},"repairItems":{"repairItemsId":"1","repairName":"常规保养","price":"1233"}},{"order":{"orderId":"2","deptId":"2","userName":"2","orderName":"3","payStatus":"true","price":200},"repairItems":{"repairItemsId":"3","repairName":"机修","price":"341"}},{"order":{"orderId":"3","deptId":"3","userName":"3","orderName":"4","payStatus":"true","price":300},"repairItems":{"repairItemsId":"2","repairName":"大型保养","price":"3123"}}]}
         */

        private ObjBean obj;

        public ObjBean getObj() {
            return obj;
        }

        public void setObj(ObjBean obj) {
            this.obj = obj;
        }

        public static class ObjBean {
            /**
             * orderListType : 1
             * userId : 1
             * reslut : [{"order":{"orderId":"1","deptId":"1","userName":"1","orderName":"1","payStatus":"true","price":100},"repairItems":{"repairItemsId":"1","repairName":"常规保养","price":"1233"}},{"order":{"orderId":"2","deptId":"2","userName":"2","orderName":"3","payStatus":"true","price":200},"repairItems":{"repairItemsId":"3","repairName":"机修","price":"341"}},{"order":{"orderId":"3","deptId":"3","userName":"3","orderName":"4","payStatus":"true","price":300},"repairItems":{"repairItemsId":"2","repairName":"大型保养","price":"3123"}}]
             */

            private String orderListType;
            private String userId;
            private List<ReslutBean> reslut;

            public String getOrderListType() {
                return orderListType;
            }

            public void setOrderListType(String orderListType) {
                this.orderListType = orderListType;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public List<ReslutBean> getReslut() {
                return reslut;
            }

            public void setReslut(List<ReslutBean> reslut) {
                this.reslut = reslut;
            }

            public static class ReslutBean {
                /**
                 * order : {"orderId":"1","deptId":"1","userName":"1","orderName":"1","payStatus":"true","price":100}
                 * repairItems : {"repairItemsId":"1","repairName":"常规保养","price":"1233"}
                 */

                private OrderBean order;
                private RepairItemsBean repairItems;

                public OrderBean getOrder() {
                    return order;
                }

                public void setOrder(OrderBean order) {
                    this.order = order;
                }

                public RepairItemsBean getRepairItems() {
                    return repairItems;
                }

                public void setRepairItems(RepairItemsBean repairItems) {
                    this.repairItems = repairItems;
                }

                public static class OrderBean {
                    /**
                     * orderId : 1
                     * deptId : 1
                     * userName : 1
                     * orderName : 1
                     * payStatus : true
                     * price : 100
                     */

                    private String orderId;
                    private String deptId;
                    private String userName;
                    private String orderName;
                    private String payStatus;
                    private int price;

                    public String getOrderId() {
                        return orderId;
                    }

                    public void setOrderId(String orderId) {
                        this.orderId = orderId;
                    }

                    public String getDeptId() {
                        return deptId;
                    }

                    public void setDeptId(String deptId) {
                        this.deptId = deptId;
                    }

                    public String getUserName() {
                        return userName;
                    }

                    public void setUserName(String userName) {
                        this.userName = userName;
                    }

                    public String getOrderName() {
                        return orderName;
                    }

                    public void setOrderName(String orderName) {
                        this.orderName = orderName;
                    }

                    public String getPayStatus() {
                        return payStatus;
                    }

                    public void setPayStatus(String payStatus) {
                        this.payStatus = payStatus;
                    }

                    public int getPrice() {
                        return price;
                    }

                    public void setPrice(int price) {
                        this.price = price;
                    }
                }

                public static class RepairItemsBean {
                    /**
                     * repairItemsId : 1
                     * repairName : 常规保养
                     * price : 1233
                     */

                    private String repairItemsId;
                    private String repairName;
                    private String price;

                    public String getRepairItemsId() {
                        return repairItemsId;
                    }

                    public void setRepairItemsId(String repairItemsId) {
                        this.repairItemsId = repairItemsId;
                    }

                    public String getRepairName() {
                        return repairName;
                    }

                    public void setRepairName(String repairName) {
                        this.repairName = repairName;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }
                }
            }
        }
    }
}
