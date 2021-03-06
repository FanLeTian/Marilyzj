package com.abc.marilyzj.beans;

/**
 * Created by acer on 2017/4/28.
 */

public class LoginBean extends StatusBean {

    /**
     * obj : {"userId":9,"userName":"我的姓名是8","password":"8","loginName":"loginName8","sex":"8","email":"8@qq.com"}
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
         * userId : 9
         * userName : 我的姓名是8
         * password : 8
         * loginName : loginName8
         * sex : 8
         * email : 8@qq.com
         */

        private String userId;
        private String userName;
        private String password;
        private String loginName;
        private String sex;
        private String email;

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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
