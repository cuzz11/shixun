package com.example.goodscommon.vo;

public class ResultVo {
    private int code;
    private String msg;
    private Object data;
    private ResultVo(){}
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public  static com.example.goodscommon.vo.ResultVo ok(Object data){
        com.example.goodscommon.vo.ResultVo resultVo = new com.example.goodscommon.vo.ResultVo();
        resultVo.setCode(200);
        resultVo.setMsg("ok");
        resultVo.setData(data);
        return resultVo;
    }
    public static com.example.goodscommon.vo.ResultVo ok(){
        return com.example.goodscommon.vo.ResultVo.ok(null);
    }
    public static com.example.goodscommon.vo.ResultVo error(){
        com.example.goodscommon.vo.ResultVo resultVo = new com.example.goodscommon.vo.ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg("error");
        return resultVo;
    }
    public static com.example.goodscommon.vo.ResultVo error(String msg){
        com.example.goodscommon.vo.ResultVo resultVo = new com.example.goodscommon.vo.ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
