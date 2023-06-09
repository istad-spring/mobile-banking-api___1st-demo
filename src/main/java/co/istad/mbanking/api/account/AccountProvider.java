package co.istad.mbanking.api.account;

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

    public String existsAccountNo() {
        return new SQL() {{
            SELECT("EXISTS(SELECT * FROM accounts WHERE account_no = #{accountNo})");
        }}.toString();
    }

    public String existsAccountName() {
        return new SQL() {{
            SELECT("EXISTS(SELECT * FROM accounts WHERE account_name = #{accountName})");
        }}.toString();
    }


    public String existsAccountPhoneNumber() {
        return new SQL() {{
            SELECT("EXISTS(SELECT * FROM accounts WHERE phone_number = #{phoneNumber})");
        }}.toString();
    }

}
