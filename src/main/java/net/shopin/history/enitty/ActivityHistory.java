package net.shopin.history.enitty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 券活动
 * </p>
 *
 * @author qiaomg
 * @since 2019-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActivityHistory implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 业务自增主键
     */

    private Integer sid;

    /**
     * 活动名称(外显名)
     */
    private String nameOutSide;

    /**
     * 活动名称(外显名)
     */
    private String nameInSide;

    /**
     * 活动类型 activity_type
     */
    private Integer type;

    /**
     * 会员参与类型（多类型逗号分隔）
     * member_type
     */
    private String joinMemberType;

    /**
     * 会员展示类型（多类型逗号分隔）
     * member_type
     */
    private String showMemberType;

    /**
     * 参与渠道(多渠道逗号分隔)
     * dic_source
     */
    private String sourceJoin;

    /**
     * 展示渠道(多渠道逗号分隔)
     * dic_source
     */
    private String sourceShow;

    /**
     * 限制每人活动期间总领取次数。0代表无限制。规则：<=
     */
    private Integer couponCount;

    /**
     * 与此活动互斥的活动数量
     */
    private Integer excludeCount;

    /**
     * 每次获取的奖品数量
     */
    private Integer receiveCouponNumber;

    /**
     * 消耗积分。默认0
     */
    private Integer usePoints;

    /**
     * 限制每人活动期间总领取次数。0代表无限制。规则：<=
     */
    private Integer receiveCountAll;

    /**
     * 限制每人活动期间每天领取次数。0代表无限制。规则：<=
     */
    private Integer receiveCountDay;

    /**
     * 图片OSS相对地址，用英文分号;隔开。第一个为主图
     */
    private String imgUrl;

    /**
     * 外显描述
     */
    private String descOutSide;

    /**
     * 外显描述2(备注)
     */
    private String remarksOutSide;

    /**
     * 分享活动标题
     */
    private String shareTitle;

    /**
     * 分享活动描述
     */
    private String shareDesc;

    /**
     * 活动参与开始时间
     */
    private Date joinStartTime;

    /**
     * 活动参与结束时间
     */
    private Date joinEndTime;

    /**
     * 活动展示开始时间
     */
    private Date showStartTime;

    /**
     * 活动展示结束时间
     */
    private Date showEndTime;

    /**
     * 状态：0、待审核。1、待开始。2、进行中。 3、已结束。4、已过期。5、已作废
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updater;

    private String optUser;
    private Date optTime;
    private String optType;

    @Override
    public String toString() {
        return "ActivityHistory{" +
                "id=" + id +
                ", sid=" + sid +
                ", nameOutSide='" + nameOutSide + '\'' +
                ", nameInSide='" + nameInSide + '\'' +
                ", type=" + type +
                ", joinMemberType='" + joinMemberType + '\'' +
                ", showMemberType='" + showMemberType + '\'' +
                ", sourceJoin='" + sourceJoin + '\'' +
                ", sourceShow='" + sourceShow + '\'' +
                ", couponCount=" + couponCount +
                ", excludeCount=" + excludeCount +
                ", receiveCouponNumber=" + receiveCouponNumber +
                ", usePoints=" + usePoints +
                ", receiveCountAll=" + receiveCountAll +
                ", receiveCountDay=" + receiveCountDay +
                ", imgUrl='" + imgUrl + '\'' +
                ", descOutSide='" + descOutSide + '\'' +
                ", remarksOutSide='" + remarksOutSide + '\'' +
                ", shareTitle='" + shareTitle + '\'' +
                ", shareDesc='" + shareDesc + '\'' +
                ", joinStartTime=" + joinStartTime +
                ", joinEndTime=" + joinEndTime +
                ", showStartTime=" + showStartTime +
                ", showEndTime=" + showEndTime +
                ", state=" + state +
                ", createTime=" + createTime +
                ", creater='" + creater + '\'' +
                ", updateTime=" + updateTime +
                ", updater='" + updater + '\'' +
                ", optUser='" + optUser + '\'' +
                ", optTime=" + optTime +
                ", optType='" + optType + '\'' +
                '}';
    }
}
