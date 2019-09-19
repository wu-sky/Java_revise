package com.jdbc;

/*
 *用户：sky-吴
 *日期：2019/7/16
 */

import java.sql.*;

/**
 * jdbc是sun公司规定的标准, 代码规范也是sun公司规定的. 没有太好的办法, 知道调用就行了.
 * jdbc规范:        数据库就是你的小蜜, 专门为你做事的
 * 1 加载jdbc驱动(类)                   拿起电话
 * 2 建立连接(数据库, 需要用户密码)       拨打号码
 * 3 创建statement(对象)                对话代理人, 给对方命令
 * 4 执行SQL, 得到(结果集/或者结果消息)    执行你的命令, 执行得了返回东西给你, 执行不了:臣妾做不到
 * 5 处理返回结果                        执行完毕, 发结果回来给你
 * 6 关闭结果集                          对方挂电话
 * 7 关闭statement                      你挂电话
 * 8 关闭连接                            放下电话走人
 *
 * 理一理这些角色:
 * 加载(反射)驱动的时候出来的DriverManager---10086(mysql)给你连线----> connection-----通话权利 传话sql-->
 * statement----execute(sql)---->resultSet---->大本营--->处理结果集, 处理后事....
 */
public class JdbcMysql {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1 加载jdbc驱动(类)
        //String classNameWrong="com\\mysql\\jdbc\\Driver.class";
        String className="com.mysql.jdbc.Driver";
        Class.forName(className);//classNotFound

        //2 获取连接(数据库)
        String url="jdbc:mysql://localhost:3306/db1902";
        String user="u1902";
        String password="u1902";
        //这个DriverManager哪冒出来的?? 我告诉你, 上面那个class.forName不是吃干饭的, 就是那个玩意反射出来的
        Connection connection= DriverManager.getConnection(url, user, password);//sqlException
        //因为你连接MySQl配置不正确, jdbc不能什么都不做, 但是又返回不了正确的结果给你, 只能出个异常返回来咯

        //3 创建statement 这个就相当于和数据库通话了,
        Statement statement=connection.createStatement();
        //谁给你通话的权利, 是连接上了, 才能给你通话的权利

        //4 执行sql
        String sql="select *  from t_user;";
        ResultSet resultSet=statement.executeQuery(sql); //SQLException
        //if 这里SQL语句写错了, 你想想resultSet是不是为null

        //5 处理结果, 或者什么都不做
        while (resultSet.next()){
            System.out.println("name:"+resultSet.getString("name")+
                    "  birthday:"+resultSet.getDate("birthday"));
        }

        resultSet.close();
        //如果resultSet为null当然不用关闭, 门都没有如何关门,可是出了nullPointerException,
        //下面就惨了, 下面的方法将不会执行, 数据库连接将不能正常关闭.
        statement.close();
        connection.close();

    }

}


