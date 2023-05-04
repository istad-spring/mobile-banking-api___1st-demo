package co.istad.mbanking.api.accounttype;

import org.apache.ibatis.jdbc.SQL;

public class AccountTypeProvider {
    public String buildSelectSql() {
        return new SQL() {{
            SELECT("*");
            FROM("account_types");
        }}.toString();
    }

    public String buildSelectByIdSql() {
        return new SQL() {{
            SELECT("*");
            FROM("account_types");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String buildInsertSql() {
        return new SQL() {{
            INSERT_INTO("account_types");
            VALUES("name", "#{ac.name}");
        }}.toString();
    }

    public String buildUpdateSql() {
        return new SQL() {{
            UPDATE("account_types");
            SET("name = #{ac.name}");
            WHERE("id = #{ac.id}");
        }}.toString();
    }
}
