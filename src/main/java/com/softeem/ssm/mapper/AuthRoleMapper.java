package com.softeem.ssm.mapper;

import com.softeem.ssm.pojo.AuthRoleExample;
import com.softeem.ssm.pojo.AuthRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface AuthRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_role
     *
     * @mbggenerated Sat Oct 15 17:22:53 CST 2022
     */
    int countByExample(AuthRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_role
     *
     * @mbggenerated Sat Oct 15 17:22:53 CST 2022
     */
    int deleteByExample(AuthRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_role
     *
     * @mbggenerated Sat Oct 15 17:22:53 CST 2022
     */
    int deleteByPrimaryKey(AuthRoleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_role
     *
     * @mbggenerated Sat Oct 15 17:22:53 CST 2022
     */
    int insert(AuthRoleKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_role
     *
     * @mbggenerated Sat Oct 15 17:22:53 CST 2022
     */
    int insertSelective(AuthRoleKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_role
     *
     * @mbggenerated Sat Oct 15 17:22:53 CST 2022
     */
    List<AuthRoleKey> selectByExample(AuthRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_role
     *
     * @mbggenerated Sat Oct 15 17:22:53 CST 2022
     */
    int updateByExampleSelective(@Param("record") AuthRoleKey record, @Param("example") AuthRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_role
     *
     * @mbggenerated Sat Oct 15 17:22:53 CST 2022
     */
    int updateByExample(@Param("record") AuthRoleKey record, @Param("example") AuthRoleExample example);
}