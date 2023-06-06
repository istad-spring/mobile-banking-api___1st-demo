package co.istad.mbanking.api.account;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class AccountProvider implements ProviderMethodResolver {

    public static String select() {
        return new SQL() {{
            SELECT("*");
            FROM("accounts");
        }}.toString();
    }

}
