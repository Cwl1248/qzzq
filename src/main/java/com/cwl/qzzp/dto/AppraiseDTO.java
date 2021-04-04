package com.cwl.qzzp.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * appraise
 * @author 
 */
@Data
public class AppraiseDTO implements Serializable {
    /**
     * 主键
     */
    private String itemid;

    /**
     * 评论者ID
     */
    private String userid;

    /**
     * 综合评分
     */
    private Double multiplescore;

    /**
     * 描述相符
     */
    private Double matchscore;

    /**
     * 对面试官的评分
     */
    private Double ratingtheinterviewe;

    /**
     * 公司环境评分
     */
    private Double environment;

    /**
     * 面试过程
     */
    private String interviewprocess;

    /**
     * 面试岗位Id
     */
    private String dataid;

    /**
     * 评价标签1
     */
    private String evaluationlabel1;

    /**
     * 评价标签2
     */
    private String evaluationlabel2;

    /**
     * 评价标签3
     */
    private String evaluationlabel3;

    /**
     * 评价标签4
     */
    private String evaluationlabel4;

    /**
     * 评价标签5
     */
    private String evaluationlabel5;

    /**
     * 创建时间
     */
    private Date cratetime;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AppraiseDTO other = (AppraiseDTO) that;
        return (this.getItemid() == null ? other.getItemid() == null : this.getItemid().equals(other.getItemid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getMultiplescore() == null ? other.getMultiplescore() == null : this.getMultiplescore().equals(other.getMultiplescore()))
            && (this.getMatchscore() == null ? other.getMatchscore() == null : this.getMatchscore().equals(other.getMatchscore()))
            && (this.getRatingtheinterviewe() == null ? other.getRatingtheinterviewe() == null : this.getRatingtheinterviewe().equals(other.getRatingtheinterviewe()))
            && (this.getEnvironment() == null ? other.getEnvironment() == null : this.getEnvironment().equals(other.getEnvironment()))
            && (this.getInterviewprocess() == null ? other.getInterviewprocess() == null : this.getInterviewprocess().equals(other.getInterviewprocess()))
            && (this.getDataid() == null ? other.getDataid() == null : this.getDataid().equals(other.getDataid()))
            && (this.getEvaluationlabel1() == null ? other.getEvaluationlabel1() == null : this.getEvaluationlabel1().equals(other.getEvaluationlabel1()))
            && (this.getEvaluationlabel2() == null ? other.getEvaluationlabel2() == null : this.getEvaluationlabel2().equals(other.getEvaluationlabel2()))
            && (this.getEvaluationlabel3() == null ? other.getEvaluationlabel3() == null : this.getEvaluationlabel3().equals(other.getEvaluationlabel3()))
            && (this.getEvaluationlabel4() == null ? other.getEvaluationlabel4() == null : this.getEvaluationlabel4().equals(other.getEvaluationlabel4()))
            && (this.getEvaluationlabel5() == null ? other.getEvaluationlabel5() == null : this.getEvaluationlabel5().equals(other.getEvaluationlabel5()))
            && (this.getCratetime() == null ? other.getCratetime() == null : this.getCratetime().equals(other.getCratetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemid() == null) ? 0 : getItemid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getMultiplescore() == null) ? 0 : getMultiplescore().hashCode());
        result = prime * result + ((getMatchscore() == null) ? 0 : getMatchscore().hashCode());
        result = prime * result + ((getRatingtheinterviewe() == null) ? 0 : getRatingtheinterviewe().hashCode());
        result = prime * result + ((getEnvironment() == null) ? 0 : getEnvironment().hashCode());
        result = prime * result + ((getInterviewprocess() == null) ? 0 : getInterviewprocess().hashCode());
        result = prime * result + ((getDataid() == null) ? 0 : getDataid().hashCode());
        result = prime * result + ((getEvaluationlabel1() == null) ? 0 : getEvaluationlabel1().hashCode());
        result = prime * result + ((getEvaluationlabel2() == null) ? 0 : getEvaluationlabel2().hashCode());
        result = prime * result + ((getEvaluationlabel3() == null) ? 0 : getEvaluationlabel3().hashCode());
        result = prime * result + ((getEvaluationlabel4() == null) ? 0 : getEvaluationlabel4().hashCode());
        result = prime * result + ((getEvaluationlabel5() == null) ? 0 : getEvaluationlabel5().hashCode());
        result = prime * result + ((getCratetime() == null) ? 0 : getCratetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemid=").append(itemid);
        sb.append(", userid=").append(userid);
        sb.append(", multiplescore=").append(multiplescore);
        sb.append(", matchscore=").append(matchscore);
        sb.append(", ratingtheinterviewe=").append(ratingtheinterviewe);
        sb.append(", environment=").append(environment);
        sb.append(", interviewprocess=").append(interviewprocess);
        sb.append(", dataid=").append(dataid);
        sb.append(", evaluationlabel1=").append(evaluationlabel1);
        sb.append(", evaluationlabel2=").append(evaluationlabel2);
        sb.append(", evaluationlabel3=").append(evaluationlabel3);
        sb.append(", evaluationlabel4=").append(evaluationlabel4);
        sb.append(", evaluationlabel5=").append(evaluationlabel5);
        sb.append(", cratetime=").append(cratetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}