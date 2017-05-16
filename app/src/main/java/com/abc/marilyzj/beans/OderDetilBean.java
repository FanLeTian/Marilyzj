package com.abc.marilyzj.beans;

/**
 * Created by acer on 2017/5/16.
 */

public class OderDetilBean extends StatusBean {


    /**
     * obj : {"obj":{"order":{"orderId":"1","deptId":"1","userName":"1","orderName":"1","payStatus":"true","price":100},"repairItems":{"repairItemsId":"1","repairName":"常规保养","price":"1233"}}}
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
         * obj : {"order":{"orderId":"1","deptId":"1","userName":"1","orderName":"1","payStatus":"true","price":100},"repairItems":{"repairItemsId":"1","repairName":"常规保养","price":"1233"}}
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
