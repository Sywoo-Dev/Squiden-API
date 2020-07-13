package fr.sywoo.api.reward;

import java.util.Date;

public class Reward {

    private String rewardName;
    private boolean isClaim;
    private boolean canClaim;
    private Date recieveDate;
    private Date claimDate;
    private Object reward;
    private boolean canRepeat;

    public Reward(String rewardName, boolean canClaim, Date recieveDate, Object reward, boolean canRepeat) {
        this.rewardName = rewardName;
        this.canClaim = canClaim;
        this.recieveDate = recieveDate;
        this.reward = reward;
        this.canRepeat = canRepeat;
    }

    public String getRewardName() {
        return rewardName;
    }

    public Reward setRewardName(String rewardName) {
        this.rewardName = rewardName;
        return this;
    }

    public boolean isClaim() {
        return isClaim;
    }

    public Reward setClaim(boolean claim) {
        isClaim = claim;
        return this;
    }

    public boolean isCanClaim() {
        return canClaim;
    }

    public Reward setCanClaim(boolean canClaim) {
        this.canClaim = canClaim;
        return this;
    }

    public Date getRecieveDate() {
        return recieveDate;
    }

    public Reward setRecieveDate(Date recieveDate) {
        this.recieveDate = recieveDate;
        return this;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public Reward setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
        return this;
    }

    public Object getReward() {
        return reward;
    }

    public Reward setReward(Object reward) {
        this.reward = reward;
        return this;
    }

    public boolean isCanRepeat() {
        return canRepeat;
    }

    public Reward setCanRepeat(boolean canRepeat) {
        this.canRepeat = canRepeat;
        return this;
    }
}
