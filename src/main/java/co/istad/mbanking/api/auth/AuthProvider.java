package co.istad.mbanking.api.auth;

import org.apache.ibatis.jdbc.SQL;

public class AuthProvider {

    public String buildRegisterSql() {
        return new SQL() {{
            INSERT_INTO("users");
            VALUES("email", "#{u.email}");
            VALUES("password", "#{u.password}");
            VALUES("is_verified", "#{u.isVerified}");
            VALUES("is_deleted", "FALSE");
        }}.toString();
    }

}
