package com.abc.marilyzj.beans;

/**
 * Created by acer on 2017/5/25.
 */

public class ChangeOderTypeBean extends StatusBean {

    /**
     * obj : {"orderId":"BA12AF533B53479E85E2FE5CA0B5B74F","deptId":"2","userId":"111","userName":"jiachao","orderName":"常规保养","orderData":"2017.7.7","payStatus":"2","price":"1233.0","phone":"1220"}
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
         * orderId : BA12AF533B53479E85E2FE5CA0B5B74F
         * deptId : 2
         * userId : 111
         * userName : jiachao
         * orderName : 常规保养
         * orderData : 2017.7.7
         * payStatus : 2
         * price : 1233.0
         * phone : 1220
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
    }
}
