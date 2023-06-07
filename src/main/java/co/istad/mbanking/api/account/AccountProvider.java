package co.istad.mbanking.api.account;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class AccountProvider implements ProviderMethodResolver {

    public static String selectByNameOrNo() {
        return new SQL() {{
            SELECT("*");
            FROM("accounts");
            WHERE("account_no = #{accountNameOrNo}");
            OR();
            WHERE("account_name = #{accountNameOrNo}");
        }}.toString();
    }

    public static String select() {
        return new SQL() {{
            SELECT("*");
            FROM("accounts");
        }}.toString();
    }

}
