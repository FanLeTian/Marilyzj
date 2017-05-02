package com.abc.marilyzj.beans;

/**
 * Created by acer on 2017/4/28.
 */

public class RegisterBean extends StatusBean {


    /**
     * obj : {"userId":11,"password":"123456","loginName":"jiachao"}
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
         * password : 123456
         * loginName : jiachao
         */

        private String userId;
        private String password;
        private String loginName;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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
    }
}
