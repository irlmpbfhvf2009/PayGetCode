package init;

import java.util.UUID;

public class AutoGenerator {
    private static String mpsPath = Config.MPS_PATH.getStringValue();
    private static String hotfixVersion = Config.HOTFIX_VERSION.getStringValue();
    private static String tppc = Config.TPPC.getStringValue();

    public static void script(){
        DatabaseManager.initData();
        create_flyway1();
    }

    private static void create_flyway1(){
        Utils.filename = "V" + hotfixVersion + ".1__add_" + tppc.toLowerCase() + ".sql";
        Utils.path = mpsPath + "/mps-flyway/profile/local/db/migration/" + Utils.filename;
        String uuid = String.valueOf(UUID.randomUUID());
        Utils.createNewFile();
        Utils.writeln(DatabaseManager.getCommand(1));
        Utils.writeln(DatabaseManager.getCommand(2));
        Utils.writeln(DatabaseManager.getCommand(3));
        Utils.write(DatabaseManager.getCommand(4));
        Utils.write(uuid);
        Utils.write(DatabaseManager.getCommand(5));
        Utils.write(Config.TPPC.getStringValue());
        Utils.write(DatabaseManager.getCommand(5));
        Utils.write(DatabaseManager.getCommand(6));
        Utils.write(Config.THIRD_PARTY_NAME.getStringValue());
        Utils.write(DatabaseManager.getCommand(7));
        Utils.write(Config.THIRD_PARTY_NAME.getStringValue());
        Utils.write(DatabaseManager.getCommand(8));
        Utils.write(Config.THIRD_PARTY_NAME.getStringValue());
        Utils.writeln(DatabaseManager.getCommand(9));
        Utils.write(DatabaseManager.getCommand(10));
        JsonObject map = new JsonObject();
        if(Config.MERCHANT_NO.getBooleanValue()){
            map.put("merchantno", "");
        }
        if(Config.MERCHANT_KEY.getBooleanValue()){
            map.put("merchantkey", "");
        }
        if(Config.PUBLIC_KEY.getBooleanValue()){
            map.put("serverpublickey", "");
        }
        if(Config.PRIVATE_KEY.getBooleanValue()){
            map.put("privatekeycontent", "");
        }
        map.put("payinapiurl", Config.PAYIN_URL.getStringValue());
        if(Config.SUPPORT_PAYOUT.getBooleanValue()){
            String payout_url = Config.PAYOUT_URL.getStringValue().equals("") ? Config.PAYIN_URL.getStringValue() : Config.PAYOUT_URL.getStringValue();
            map.put("payoutapiurl", payout_url);
        }
        Utils.write(map.toString());
        Utils.writeln(DatabaseManager.getCommand(11));
        Utils.writeln();
        Utils.writeln();
    }


}
