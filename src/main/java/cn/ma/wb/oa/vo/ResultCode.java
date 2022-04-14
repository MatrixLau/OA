package cn.ma.wb.oa.vo;


public enum ResultCode {

    /**
     * Member相关Code
     */
    MEMBER_ADD_SUCCESS("M001", "成员添加成功！"),
    MEMBER_DEL_SUCCESS("M002", "成员删除成功"),
    MEMBER_EDIT_SUCCESS("M003", "成员修改成功！"),
    MEMBER_FIND_SUCCESS("M004", "成员查询成功！"),
    LOGIN_SUCCESS("M005", "登录成功！"),
    TICKET_SUBMIT_SUCCESS("T001", "申请提交成功！"),
    TICKET_DEL_SUCCESS("T002", "申请删除成功！"),
    TICKET_EDIT_SUCCESS("T003", "申请修改成功！"),
    TICKET_FIND_SUCCESS("T004", "申请查询成功！"),
    CLASS_FIND_SUCCESS("C004", "班级查询成功！"),

    USER_MISSING("M100", "找不到该用户！"),
    CLASS_MISSING("C100", "找不到该班级！"),
    MEMBER_ID_MISSING("M101", "找不到ID！"),
    MEMBER_USERNAME_MISSING("M102", "找不到用户名！"),
    MEMBER_EDIT_MISSING("M103","无修改项！"),
    TICKET_MISSING("T100", "找不到申请！"),

    PASSWORD_ERROR("M201", "密码错误！"),

    MEMBER_ADD_FAIL("M301", "成员添加失败！"),
    MEMBER_DEL_FAIL("M302", "成员删除失败"),
    MEMBER_EDIT_FAIL("M303", "成员修改失败！"),
    MEMBER_FIND_FAIL("M304", "成员查询失败！"),
    TICKET_SUBMIT_FAIL("T301", "申请提交失败！"),
    TICKET_DEL_FAIL("T302", "申请删除失败！"),
    TICKET_EDIT_FAIL("T303", "申请修改失败！"),
    CLASS_FIND_FAIL("C301", "班级查询失败！");



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
