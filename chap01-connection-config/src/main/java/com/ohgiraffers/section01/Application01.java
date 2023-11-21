package com.ohgiraffers.section01;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

import java.util.Date;

public class Application01 {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "menu";
    private static String PASS = "menu";

    public static void main(String[] args) {

        /*
        * JdbcTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 오토 커밋
        * =======================================
        * PooledDataSource : ConnectionPool을 사용함
        * UnPooledDataSource : ConnectionPool을 사용하지 않음
        * */
        // 환경 정보 Environment 저장 객체에 아이디, 종류, 커넥션 툴 사용 유무 저장
        Environment environment = new Environment(
                "dev", // 환경에 대한 이름
                new JdbcTransactionFactory(), // 수동 커밋 상태
                new PooledDataSource(DRIVER, URL, USER, PASS) // 안의 정보들을 토대로 커넥션 객체들을 관리함
        );

        // 환경 정보를 config에 저장
        Configuration config = new Configuration(environment);

        // Sql Mapper 인터페이스 저장 (Mapper가 DAO 역할)
        config.addMapper(Mapper.class);

        /*
        * SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 필드 역할
        * Build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연관된 Stream을 매개변수로 전달하면,
        *           SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
        * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);

        // 세션 만들기
        /*
        * openSession : SqlSqssion 인터페이스 타입의 객체를 반환하는 메소드로 boolean 타입을 인자로 전달
        * - false : Connection 인터페이스 타입 객체로 Dml(update, insert, delete) 수행 후 Auto Commit에 대한 옵션을 false로 지정 (권장)
        * - true : Connection 인터페이스 타입 객체로 Dml 수행 후 Auto Commit에 대한 옵션을 true로 지정
        * */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // 어떻게 되어있는지 모른다. (캡슐화) / 구현체는 Mapper 파일 안에 있음..
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Date date = mapper.selectSysDate();

        System.out.println(date);

        sqlSession.close();

        /*
        Mapper mapper2 = new Mapper() {
            @Override
            public Date selectSysDate() {
                return null;
            }
        };
        mapper2.selectSysDate();
        */


    }
}
