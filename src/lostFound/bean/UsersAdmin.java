package lostFound.bean;

import java.util.Date;

public class UsersAdmin {
    /**
     * UsersAdmin
     * 	websiteId
     * 	websiteLogo				网站logo
     * 	websiteName				站点名
     * 	websiteDescription		描述
     * 	websiteRange			主要范围(例如：长沙民政)
     * 	websiteAdmin			属于谁
     * 	websiteContact			联系电话（可作为登录
     *  websiteAddress			所属于人地址
     *  websiteCreateTime       创建日期
     *
     * 	websiteAdminUsername	电子邮件（可作为登录
     * 	websiteAdminPassword	密码
     */

    private int websiteId;
    private String websiteLogo;
    private String websiteName;
    private String websiteDescription;
    private Date websiteRange;
    private String websiteAdmin;
    private String websiteContact;
    private Date websiteCreateTime;
    private String websiteAdminUsername;
    private String websiteAdminPassword;

    public int getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }

    public String getWebsiteLogo() {
        return websiteLogo;
    }

    public void setWebsiteLogo(String websiteLogo) {
        this.websiteLogo = websiteLogo;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteDescription() {
        return websiteDescription;
    }

    public void setWebsiteDescription(String websiteDescription) {
        this.websiteDescription = websiteDescription;
    }

    public Date getWebsiteRange() {
        return websiteRange;
    }

    public void setWebsiteRange(Date websiteRange) {
        this.websiteRange = websiteRange;
    }

    public String getWebsiteAdmin() {
        return websiteAdmin;
    }

    public void setWebsiteAdmin(String websiteAdmin) {
        this.websiteAdmin = websiteAdmin;
    }

    public String getWebsiteContact() {
        return websiteContact;
    }

    public void setWebsiteContact(String websiteContact) {
        this.websiteContact = websiteContact;
    }

    public Date getWebsiteCreateTime() {
        return websiteCreateTime;
    }

    public void setWebsiteCreateTime(Date websiteCreateTime) {
        this.websiteCreateTime = websiteCreateTime;
    }

    public String getWebsiteAdminUsername() {
        return websiteAdminUsername;
    }

    public void setWebsiteAdminUsername(String websiteAdminUsername) {
        this.websiteAdminUsername = websiteAdminUsername;
    }

    public String getWebsiteAdminPassword() {
        return websiteAdminPassword;
    }

    public void setWebsiteAdminPassword(String websiteAdminPassword) {
        this.websiteAdminPassword = websiteAdminPassword;
    }

    public UsersAdmin() {
    }

    @Override
    public String toString() {
        return "UsersAdmin{" +
                "websiteId=" + websiteId +
                ", websiteLogo='" + websiteLogo + '\'' +
                ", websiteName='" + websiteName + '\'' +
                ", websiteDescription='" + websiteDescription + '\'' +
                ", websiteRange=" + websiteRange +
                ", websiteAdmin='" + websiteAdmin + '\'' +
                ", websiteContact='" + websiteContact + '\'' +
                ", websiteCreateTime=" + websiteCreateTime +
                ", websiteAdminUsername='" + websiteAdminUsername + '\'' +
                ", websiteAdminPassword='" + websiteAdminPassword + '\'' +
                '}';
    }
}
