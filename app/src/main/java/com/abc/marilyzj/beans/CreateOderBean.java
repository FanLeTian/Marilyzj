package com.abc.marilyzj.beans;

/**
 * Created by acer on 2017/5/25.
 */

public class CreateOderBean extends StatusBean {

    /**
     * obj : {"orderId":"D2DE717ADDEB445D8F9C9D5A656D5498","deptId":"579967EFF17A4C0EB23DADEF5F903FE4","userId":"28634F54F1934808BACFEC68A0F16F55","userName":"sgsg","orderName":"机油","orderData":"fszwsgsg","payStatus":"1","price":"542","phone":"sgsgse","eamil":"srgsgs","remark":"sgsgsg"}
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
         * orderId : D2DE717ADDEB445D8F9C9D5A656D5498
         * deptId : 579967EFF17A4C0EB23DADEF5F903FE4
         * userId : 28634F54F1934808BACFEC68A0F16F55
         * userName : sgsg
         * orderName : 机油
         * orderData : fszwsgsg
         * payStatus : 1
         * price : 542
         * phone : sgsgse
         * eamil : srgsgs
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
        private String eamil;
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

        public String getEamil() {
            return eamil;
        }

        public void setEamil(String eamil) {
            this.eamil = eamil;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
