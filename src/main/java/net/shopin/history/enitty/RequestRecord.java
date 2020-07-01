package net.shopin.history.enitty;

import java.util.Date;

/**
 * request_record
 * @author
 */
public class RequestRecord{
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 操作类型  OK , FAIL,REFRESH,
     */
    private String type;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 服务名称
     */
    private String serverName;

    /**
     * 执行的sql 字符串
     */
    private String optSql;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 状态 0 无效 1 有效
     */
    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getOptSql() {
        return optSql;
    }

    public void setOptSql(String optSql) {
        this.optSql = optSql;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RequestRecord{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", tableName='" + tableName + '\'' +
                ", serverName='" + serverName + '\'' +
                ", optSql='" + optSql + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", state=" + state +
                '}';
    }
}
