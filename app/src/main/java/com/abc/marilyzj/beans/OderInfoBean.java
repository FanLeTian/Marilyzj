package com.abc.marilyzj.beans;

/**
 * Created by acer on 2017/5/25.
 */

public class OderInfoBean extends StatusBean {

    /**
     * obj : {"obj":{"order":{"orderId":"AE739013FC37400BB334F688C4FE977B","deptId":"579967EFF17A4C0EB23DADEF5F903FE4","userId":"28634F54F1934808BACFEC68A0F16F55","userName":"sgsg","orderName":"机油","orderData":"fszwsgsg","payStatus":"1","price":"542.0","phone":"sgsgse","remark":"sgsgsg"},"repairItems":{"repairItemsId":"101","repairName":"机油","price":"542"},"dept":{"deptId":"579967EFF17A4C0EB23DADEF5F903FE4","deptName":"万达4S","deptAddress":"万达广场","deptPhone":"231321","deptEmail":"21344@qq.com","deptDesc":"万达广场","deptLevel":5}}}
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
         * obj : {"order":{"orderId":"AE739013FC37400BB334F688C4FE977B","deptId":"579967EFF17A4C0EB23DADEF5F903FE4","userId":"28634F54F1934808BACFEC68A0F16F55","userName":"sgsg","orderName":"机油","orderData":"fszwsgsg","payStatus":"1","price":"542.0","phone":"sgsgse","remark":"sgsgsg"},"repairItems":{"repairItemsId":"101","repairName":"机油","price":"542"},"dept":{"deptId":"579967EFF17A4C0EB23DADEF5F903FE4","deptName":"万达4S","deptAddress":"万达广场","deptPhone":"231321","deptEmail":"21344@qq.com","deptDesc":"万达广场","deptLevel":5}}
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
             * order : {"orderId":"AE739013FC37400BB334F688C4FE977B","deptId":"579967EFF17A4C0EB23DADEF5F903FE4","userId":"28634F54F1934808BACFEC68A0F16F55","userName":"sgsg","orderName":"机油","orderData":"fszwsgsg","payStatus":"1","price":"542.0","phone":"sgsgse","remark":"sgsgsg"}
             * repairItems : {"repairItemsId":"101","repairName":"机油","price":"542"}
             * dept : {"deptId":"579967EFF17A4C0EB23DADEF5F903FE4","deptName":"万达4S","deptAddress":"万达广场","deptPhone":"231321","deptEmail":"21344@qq.com","deptDesc":"万达广场","deptLevel":5}
             */

            private OrderBean order;
            private RepairItemsBean repairItems;
            private DeptBean dept;

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

            public DeptBean getDept() {
                return dept;
            }

            public void setDept(DeptBean dept) {
                this.dept = dept;
            }

            public static class OrderBean {
                /**
                 * orderId : AE739013FC37400BB334F688C4FE977B
                 * deptId : 579967EFF17A4C0EB23DADEF5F903FE4
                 * userId : 28634F54F1934808BACFEC68A0F16F55
                 * userName : sgsg
                 * orderName : 机油
                 * orderData : fszwsgsg
                 * payStatus : 1
                 * price : 542.0
                 * phone : sgsgse
                 * remark : sgsgsg
                 */

                private String orderId;
                private String deptId;
                private String userId;
                private String userName;
                private String orderName;
                private String orderData;
                private String payStatus;
                private String price;
                private String phone;
                private String remark;

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

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
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

                public String getOrderData() {
                    return orderData;
                }

                public void setOrderData(String orderData) {
                    this.orderData = orderData;
                }

                public String getPayStatus() {
                    return payStatus;
                }

                public void setPayStatus(String payStatus) {
                    this.payStatus = payStatus;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }
            }

            public static class RepairItemsBean {
                /**
                 * repairItemsId : 101
                 * repairName : 机油
                 * price : 542
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

            public static class DeptBean {
                /**
                 * deptId : 579967EFF17A4C0EB23DADEF5F903FE4
                 * deptName : 万达4S
                 * deptAddress : 万达广场
                 * deptPhone : 231321
                 * deptEmail : 21344@qq.com
                 * deptDesc : 万达广场
                 * deptLevel : 5
                 */

                private String deptId;
                private String deptName;
                private String deptAddress;
                private String deptPhone;
                private String deptEmail;
                private String deptDesc;
                private int deptLevel;

                public String getDeptId() {
                    return deptId;
                }

                public void setDeptId(String deptId) {
                    this.deptId = deptId;
                }

                public String getDeptName() {
                    return deptName;
                }

                public void setDeptName(String deptName) {
                    this.deptName = deptName;
                }

                public String getDeptAddress() {
                    return deptAddress;
                }

                public void setDeptAddress(String deptAddress) {
                    this.deptAddress = deptAddress;
                }

                public String getDeptPhone() {
                    return deptPhone;
                }

                public void setDeptPhone(String deptPhone) {
                    this.deptPhone = deptPhone;
                }

                public String getDeptEmail() {
                    return deptEmail;
                }

                public void setDeptEmail(String deptEmail) {
                    this.deptEmail = deptEmail;
                }

                public String getDeptDesc() {
                    return deptDesc;
                }

                public void setDeptDesc(String deptDesc) {
                    this.deptDesc = deptDesc;
                }

                public int getDeptLevel() {
                    return deptLevel;
                }

                public void setDeptLevel(int deptLevel) {
                    this.deptLevel = deptLevel;
                }
            }
        }
    }
}
