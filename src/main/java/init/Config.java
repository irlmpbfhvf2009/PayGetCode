package init;

public enum Config {
    THIRD_PARTY_NAME("JYM Pay"),
    TPPC("JYM"),
    SUPPORT_PAYOUT(true),
    HOTFIX_VERSION("004.011.00.156"),
    MERCHANT_NO(true),
    MERCHANT_KEY(true),
    PUBLIC_KEY(false),
    PRIVATE_KEY(false),
    PAYIN_URL("http://api.whalespay.net/"),
    PAYOUT_URL(""), // 留空會與PAYIN_URL相同
    MPS_PATH("/Users/leo.ye/TKTechProjects/mps-parent"),

    ;


    private final String stringValue;
    private final Boolean booleanValue;

    Config(String value) {
        this.stringValue = value;
        this.booleanValue = null;
    }

    Config(Boolean value) {
        this.stringValue = null;
        this.booleanValue = value;
    }

    public String getStringValue() {
        return stringValue;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }
}
