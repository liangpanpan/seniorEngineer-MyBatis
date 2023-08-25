package com.guxingyuan.jdbc.dao;

import com.guxingyuan.jdbc.common.CodeException;
import com.guxingyuan.jdbc.enumeration.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * <pre>
 * @Describe jdbcTemplate封装
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/6/21       create this file
 * </pre>
 */
@Component
public class JdbcTemplateDao {

    private static Logger logger = LoggerFactory.getLogger(JdbcTemplateDao.class);

    /**
     * 分页查询最大拆解值
     */
    private static final int PAGE_LIMIT_MAX = 10;

    @Resource
    private JdbcTemplate jdbcTemplate;

    private JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * 查询总数量
     *
     * @param sql 执行SQL
     * @return 返回数据int值
     */
    public Long getCount(String sql) {
        logger.debug("[sql]=[" + sql + "]");
        try {
            Long count = getJdbcTemplate().queryForObject(sql, Long.class);
            return count == null ? 0 : count;
        } catch (Exception ex) {
            logger.error("查询失败", ex);
            throw new CodeException(ErrorCodeEnum.D0003);
        }
    }

    /**
     * 计算记录的条数
     *
     * @param sql  需要预编译的SQL
     * @param args 需要按照顺序替换的变量
     * @return 返回count int值
     */
    public Long getCount(String sql, Object... args) {
        loggerSQLArgs(sql, args);
        try {
            Long result = getJdbcTemplate().queryForObject(sql, Long.class, args);
            return result == null ? 0 : result;
        } catch (Exception ex) {
            logger.error("查询失败", ex);
            throw new CodeException(ErrorCodeEnum.D0003);
        }
    }

    /**
     * 通过SQL查询，结果为String
     *
     * @param sql 查询SQL
     * @return
     */
    public String getString(String sql) {
        try {
            logger.debug("[sql]=[" + sql + "]");
            return getJdbcTemplate().queryForObject(sql, String.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 通过参数查询，结果为字符串
     *
     * @param sql  查询SQL
     * @param args 参数变量内容
     * @return
     */
    public String getString(String sql, Object... args) {
        try {
            loggerSQLArgs(sql, args);
            return getJdbcTemplate().queryForObject(sql, String.class, args);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 查询单个实体
     *
     * @param sql
     * @return
     */
    public Map<String, Object> getMap(String sql) {
        try {
            logger.debug("[sql]=[" + sql + "]");
            return getJdbcTemplate().queryForMap(sql);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 带参数查询单个实体
     *
     * @param sql
     * @param args
     * @return
     */
    public Map<String, Object> getMap(String sql, Object... args) {
        try {
            loggerSQLArgs(sql, args);
            return getJdbcTemplate().queryForMap(sql, args);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }


    /**
     * 查询SQL,返回对象,无参
     *
     * @param clazz
     * @param sql
     * @param <T>
     * @return
     */
    public <T> T getObject(Class<T> clazz, String sql) {
        try {
            logger.debug("[sql]=[" + sql + "]");
            return getJdbcTemplate().queryForObject(sql, BeanPropertyRowMapper.newInstance(clazz));
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 查询SQL,返回对象,有参
     *
     * @param clazz
     * @param sql
     * @param <T>
     * @return
     */
    public <T> T getObject(Class<T> clazz, String sql, Object... args) {
        try {
            loggerSQLArgs(sql, args);
            return getJdbcTemplate().queryForObject(sql, BeanPropertyRowMapper.newInstance(clazz), args);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    public List<Integer> getIntegerList(String sql) {
        return jdbcTemplate.queryForList(sql, Integer.class);
    }

    /**
     * 查询SQL，返回对象列表
     *
     * @param clazz
     * @param sql   查询SQL
     * @param <T>   返回类型参数
     * @return
     */
    public <T> List<T> listObjects(Class<T> clazz, String sql) {
        try {
            logger.debug("[sql]=[" + sql + "]");
            return getJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(clazz));
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 查询返回List
     *
     * @param clazz 类型
     * @param sql   查询的SQL
     * @param args  参数
     * @param <T>   结果类型
     * @return
     */
    public <T> List<T> listObjects(Class<T> clazz, String sql, Object... args) {
        try {
            if (ObjectUtils.isEmpty(args)) {
                return listObjects(clazz, sql);
            }
            loggerSQLArgs(sql, args);
            return getJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(clazz), args);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 分页进行查询，
     * LIMIT 5,10;  // 检索记录行 6-15
     *
     * @param clazz    需要返回的对象类型
     * @param querySQL 查询的SQL，只支持简单的类似于Select * From table Where XXX Order by ;
     * @param pageNo   当前查询的页面（从0开始），必须从0开始，否则Pageable计算的时候会出现异常
     * @param pageSize 查询的页面大小
     * @param args     参数
     * @param <T>      返回的类型
     * @return
     */
    public <T> Page<T> listObjectsByPages(Class<T> clazz, String querySQL, int pageNo, int pageSize, Object... args) {

        String upperCaseQuerySQL = querySQL.toUpperCase();

        // 分析countSQL
        int fromIndex = upperCaseQuerySQL.indexOf("FROM");
        int orderByIndex = upperCaseQuerySQL.indexOf("ORDER BY");

        String middleSQL = querySQL.substring(fromIndex, orderByIndex);

        String countSQL = "select count(1) " + middleSQL;

        // 获得所有的行数
        long count = getCount(countSQL);

        pageNo = countPageNo(count, pageNo, pageSize);

        // 计算偏移量
        long offset = pageNo * pageSize;

        if (offset >= PAGE_LIMIT_MAX) {
            int prefixIndex = upperCaseQuerySQL.indexOf("WHERE");
            if (prefixIndex < 0) {
                // 不存在，则找Order By
                prefixIndex = upperCaseQuerySQL.indexOf("ORDER BY");
            }

            // 如果还是超长
            if (prefixIndex < 0) {
                prefixIndex = upperCaseQuerySQL.length();
            }
            // 超过5000行，采用先查主键再查全部

            // 先分解出查询ID的SQL语句
            // 判断ID是uuid还是id
            String id = "id";
            if (upperCaseQuerySQL.contains(" UUID")) {
                id = "uuid";
            }

            String interiorSQL = "select " + id + " as targetId " + querySQL.substring(fromIndex) + " limit " + offset +
                    ", " + pageSize;
            // 获取外部的SQL
            querySQL = querySQL.substring(0, prefixIndex) + " INNER JOIN (" + interiorSQL +
                    ") tmp on " + id + " = tmp.targetId " + querySQL.substring(orderByIndex);
        } else {
            querySQL = querySQL + " limit " + offset + ", " + pageSize;
        }

        List<T> strategyWhitelistList = listObjects(clazz, querySQL, args);

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return new PageImpl<>(strategyWhitelistList, pageable, count);
    }


    /**
     * 计算查询的页数
     *
     * @param count
     * @param pageNo
     * @param pageSize
     * @return
     */
    private int countPageNo(long count, int pageNo, int pageSize) {
        // 按照每页大小，可以分为多少页
        // 计算按照分页大小，计算最后一页的大小
        long remainder = count % pageSize;

        long allPageNo = count / pageSize;
        if (remainder > 0) {
            allPageNo = allPageNo + 1;
        }

        // 页码不能减1，只能从0开始要减1
        // pageNo = pageNo - 1;

        // 如果要查询的页码大于最大页码，则只查询最大页码
        if (pageNo >= allPageNo) {
            pageNo = Long.valueOf(allPageNo - 1).intValue();
        }

        if (pageNo < 0) {
            pageNo = 0;
        }
        return pageNo;
    }

    /**
     * 分页进行查询
     * LIMIT 5,10;  // 检索记录行 6-15
     *
     * @param clazz    需要返回的对象类型
     * @param querySQL 查询的SQL，
     * @param countSQL 计算条数的SQL
     * @param pageNo   当前查询的页面（从1开始）
     * @param pageSize 查询的页面大小
     * @param args     参数
     * @param <T>      返回的类型
     * @return
     */
    @Deprecated
    public <T> Page<T> listObjectsByPages1(Class<T> clazz, String querySQL, String countSQL, int pageNo, int pageSize,
                                           Object... args) {
        // 获得所有的行数
        long count = getCount(countSQL);

        // 按照每页大小，可以分为多少页
        // 计算按照分页大小，计算最后一页的大小
        long remainder = count % pageSize;

        long allPageNo = count / pageSize;
        if (remainder > 0) {
            allPageNo = allPageNo + 1;
        }

        // 先修改为pageNo 从1开始
        // if (pageNo >= (allPageNo - 1)) {
        //     pageNo = Long.valueOf(allPageNo - 1).intValue();
        // }

        // 页码要减1
        pageNo = pageNo - 1;

        // 如果要查询的页码大于最大页码，则只查询最大页码
        if (pageNo >= allPageNo) {
            pageNo = Long.valueOf(allPageNo - 1).intValue();
        }

        if (pageNo < 0) {
            pageNo = 0;
        }

        // 计算偏移量
        long offset = pageNo * pageSize;

        querySQL = querySQL + " LIMIT {0}, {1}";

        querySQL = MessageFormat.format(querySQL, offset, pageSize);

        List<T> strategyWhitelistList = listObjects(clazz, querySQL, args);

        Pageable pageable = PageRequest.of(pageNo + 1, pageSize);

        return new PageImpl<>(strategyWhitelistList, pageable, count);
    }


    /**
     * 查询，结果返回List<Map<String, Object>>
     *
     * @param sql
     * @return
     */
    public List<Map<String, Object>> listObjects(String sql) {
        try {
            logger.debug("[sql]=[" + sql + "]");
            return getJdbcTemplate().queryForList(sql);
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 待参数的查询，结果返回List<Map<String, Object>>
     *
     * @param sql
     * @param args
     * @return
     */
    public List<Map<String, Object>> listObjects(String sql, Object... args) {
        try {
            loggerSQLArgs(sql, args);
            return getJdbcTemplate().queryForList(sql, args);
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 查询sql,结果为List<String>
     *
     * @param sql
     * @return
     */
    public List<String> listString(String sql) {
        try {
            logger.debug("[sql]=[" + sql + "]");
            return getJdbcTemplate().queryForList(sql, String.class);
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 通过参数查询，结果返回List<String>
     *
     * @param sql
     * @param args
     * @return
     */
    public List<String> listString(String sql, Object[] args) {
        try {
            loggerSQLArgs(sql, args);
            return getJdbcTemplate().queryForList(sql, String.class, args);
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 执行添加修改操作
     *
     * @param sql
     * @return
     */
    public boolean update(String sql) {
        try {
            logger.debug("[sql]=[" + sql + "]");
            int i = getJdbcTemplate().update(sql);
            return i > 0;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 执行添加修改操作
     *
     * @param sql
     * @param args
     * @return
     */
    public boolean update(String sql, Object... args) {
        try {
            loggerSQLArgs(sql, args);
            int i = getJdbcTemplate().update(sql, args);
            return i > 0;
        } catch (EmptyResultDataAccessException e) {
            return false;
        } catch (DuplicateKeyException de) {
            logger.warn("key ex: ", de);
            return false;
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            logger.error(Arrays.toString(args));
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 执行更新操作，并返回更新条数
     *
     * @param sql
     * @param args
     * @return
     */
    public int updateReturnResult(String sql, Object... args) {
        try {
            loggerSQLArgs(sql, args);
            return getJdbcTemplate().update(sql, args);
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            logger.error("args:[" + Arrays.toString(args) + "]");
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 保存并返回自增ID
     *
     * @param sql
     * @param args
     * @return
     */
    public int saveOfReturnId(String sql, Object... args) {
        GeneratedKeyHolder keyHolder = null;
        try {
            keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
                return ps;
            }, keyHolder);
            return keyHolder.getKey().intValue();
        } catch (Exception e) {
            logger.error("执行数据库操作失败", e);
            return 0;
        }
    }

    /**
     * 执行StatementCallback
     *
     * @param sql
     */
    public void execute(String sql) {
        try {
            loggerSQLArgs(sql);
            getJdbcTemplate().execute(sql);
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 执行修改操作
     *
     * @param user 操作用户
     * @param sql  执行SQL
     * @param args 参数数组
     * @return
     */
    /*public int update(String user, String sql, Object... args) {
        StringBuilder sb = new StringBuilder();
        if (null != args && args.length > 0) {
            loggerSQLArgs(sql, args, user);
            return getJdbcTemplate().update(sql, args);
        } else {
            return update(user, sql);
        }

    }*/

    /**
     * 单独执行更新SQL，不含参数
     *
     * @param user 执行用户
     * @param sql  执行SQL
     * @return
     */
    /*public int update(String user, String sql) {
        logger.info(user + " execute sql: " + sql);
        return getJdbcTemplate().update(sql);
    }*/

    /**
     * 批量执行更新SQL
     *
     * @param sql
     * @param batchArgs
     * @return
     */
    public int[] batchUpdate(String sql, List<Object[]> batchArgs) {
        try {
            logger.debug(" execute sql=[" + sql + "]\n[batchArgs size]=[" + batchArgs.size() + "]");

            /*String paramterStr = batchArgs2String(batchArgs);
            if (ObjectUtils.isEmpty(paramterStr)) {
                logger.debug(paramterStr);
            }*/
            return getJdbcTemplate().batchUpdate(sql, batchArgs);

        } catch (DuplicateKeyException e) {
            logger.warn("key ex: ", e);
            return new int[]{};
        } catch (Exception ex) {
            logger.error("执行数据库操作失败", ex);
            throw new CodeException(ErrorCodeEnum.D0001);
        }
    }

    /**
     * 对SQL进行日志打印
     *
     * @param sql
     * @param args
     */
    private void loggerSQLArgs(String sql, Object... args) {
        loggerSQLArgs(sql, null, args);
    }

    /**
     * 打印user用户执行的SQL
     *
     * @param sql  需要执行的SQL
     * @param user 执行该SQL的用户
     * @param args 参数内容列表
     */
    private void loggerSQLArgs(String sql, String user, Object... args) {
        String message;
        if (ObjectUtils.isEmpty(user)) {
            message = "[sql]=[" + sql + "]\n";
        } else {
            message = user + " execute sql=[" + sql + "]\n";
        }
        logger.debug(message + "[args]=[" + args2String(args) + "]");
    }

    /**
     * 将对象列表，中间用","组装成字符串
     *
     * @param args 参数数组
     */
    private String args2String(Object... args) {
        if (ObjectUtils.isEmpty(args)) {
            return "";
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (Object obj : args) {
            if (obj == null) {
                joiner.add("@null");
            } else {
                joiner.add(obj.toString());
            }
        }
        return joiner.toString();
    }

    /**
     * 将批量操作的变量转换成字符串
     *
     * @param batchArgs
     * @return
     */
    private String batchArgs2String(List<Object[]> batchArgs) {
        StringBuilder builder = new StringBuilder();
        int size = batchArgs.size();
        for (int i = 0; i < size; i++) {
            builder.append("\n[args[" + String.valueOf(i) + "]]=[");
            builder.append(args2String(batchArgs.get(i)));
            builder.append("]");
        }
        return builder.toString();
    }
}
