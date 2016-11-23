package org.ziyang.dal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.ziyang.dal.model.Blog;
import org.ziyang.dal.model.BlogExample;

public interface BlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @SelectProvider(type=BlogSqlProvider.class, method="countByExample")
    long countByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @DeleteProvider(type=BlogSqlProvider.class, method="deleteByExample")
    int deleteByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @Delete({
        "delete from blog",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @Insert({
        "insert into blog (id, title, ",
        "created_time, revise_time, ",
        "content)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{createdTime,jdbcType=TIMESTAMP}, #{reviseTime,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insert(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @InsertProvider(type=BlogSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertSelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @SelectProvider(type=BlogSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="revise_time", property="reviseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @SelectProvider(type=BlogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="revise_time", property="reviseTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Blog> selectByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, title, created_time, revise_time, content",
        "from blog",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="revise_time", property="reviseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Blog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @UpdateProvider(type=BlogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @UpdateProvider(type=BlogSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @UpdateProvider(type=BlogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @UpdateProvider(type=BlogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @Update({
        "update blog",
        "set title = #{title,jdbcType=VARCHAR},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "revise_time = #{reviseTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    @Update({
        "update blog",
        "set title = #{title,jdbcType=VARCHAR},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "revise_time = #{reviseTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Blog record);
}