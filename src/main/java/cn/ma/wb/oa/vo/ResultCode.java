package cn.ma.wb.oa.vo;


public enum ResultCode {

    /**
     * Member相关Code
     */
    ADD_SUCCESS("M001", "添加成功！"),
    DEL_SUCCESS("M002", "删除成功"),
    EDIT_SUCCESS("M003", "修改成功！"),
    FIND_SUCCESS("M004", "查询成功！"),
    LOGIN_SUCCESS("M005", "登录成功！"),
    SUBMIT_SUCCESS("T001", "提交成功！"),
    TICKET_FIND_SUCCESS("T004", "查询成功！"),

    ID_MISSING("M101", "找不到ID！"),
    USERNAME_MISSING("M102", "找不到用户名！"),
    EDIT_MISSING("M103","无修改项！"),
    TICKET_MISSING("T101", "找不到申请！"),

    PASSWORD_ERROR("M201", "密码错误！"),

    ADD_FAIL("M301", "添加失败！"),
    DEL_FAIL("M302", "删除失败"),
    EDIT_FAIL("M303", "修改失败！"),
    FIND_FAIL("M304", "查询失败！"),
    SUBMIT_FAIL("T301", "提交失败！");



    private String code;
    private String message;

    ResultCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
