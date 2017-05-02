package com.abc.marilyzj.beans;

/**
 * Created by acer on 2017/4/28.
 */

public class SetInfoBean extends StatusBean {

    /**
     * obj : {"userId":11,"userName":"è´¾è¶\u0085","loginName":"jiachao","sex":"dd","phone":"110","email":"jia_chao23@126.com","remark":""}
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
         * userId : 11
         * userName : è´¾è¶
         * loginName : jiachao
         * sex : dd
         * phone : 110
         * email : jia_chao23@126.com
         * remark :
         */

        private String userId;
        private String userName;
        private String loginName;
        private String sex;
        private String phone;
        private String email;
        private String remark;

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

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
