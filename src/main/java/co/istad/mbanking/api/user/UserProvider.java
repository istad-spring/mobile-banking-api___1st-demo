package co.istad.mbanking.api.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    private static final String tableName = "users";

    public String buildUpdateByIdSql() {
        return new SQL() {{
            UPDATE(tableName);
            SET("name = #{u.name}");
            SET("gender = #{u.gender}");
            WHERE("id = #{u.id}");
        }}.toString();
    }

    public String buildUpdateIsDeletedByIdSql() {
        return new SQL() {{
            UPDATE(tableName);
            SET("is_deleted = #{status}");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String buildDeleteByIdSql() {
        return new SQL() {{
            DELETE_FROM(tableName);
            WHERE("id = #{id}");
        }}.toString();
    }
    public String buildInsertSql(@Param("u") User user) {
        return new SQL() {{
            INSERT_INTO(tableName);
            VALUES("name", "#{u.name}");
            VALUES("gender", "#{u.gender}");
            VALUES("one_signal_id", "#{u.oneSignalId}");

            if (!user.getStudentCardId().isBlank()) {
                VALUES("student_card_id", "#{u.studentCardId}");
            }

            VALUES("is_student", "#{u.isStudent}");
            VALUES("is_deleted", "FALSE");
        }}.toString();
    }

    public String buildSelectByIdSql() {
        return new SQL() {{
            SELECT("*");
            FROM(tableName);
            WHERE("id = #{id}", "is_deleted = FALSE");
        }}.toString();
    }

    public String buildSelectSql() {
        return new SQL() {{
            SELECT("*");
            FROM("users");
            WHERE("name ILIKE '%' || #{name} || '%'" ,"is_deleted = FALSE");
            ORDER_BY("id DESC");
        }}.toString();
    }

    public String buildSelectByStudentCardIdSql() {
        return new SQL() {{
            SELECT("*");
            FROM(tableName);
            WHERE("student_card_id = #{studentCardId}", "is_deleted = FALSE");
        }}.toString();
    }

}
