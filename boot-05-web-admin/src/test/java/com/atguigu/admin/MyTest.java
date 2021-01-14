package com.atguigu.admin;

import com.baomidou.mybatisplus.extension.api.Assert;
import org.apache.ibatis.jdbc.Null;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class MyTest {
    @Test
    @RepeatedTest(5)
    public void testRepeated(){
        System.out.println("Repeated");
    }

    @Test
    @DisplayName("测试2")
    public void DisplayNameTest(){
        System.out.println("DisplayNameTest");
    }

    @Test
    @BeforeEach()
    public void BeforeEachTest(){
        System.out.println("BeforeEach");
    }

    @Test
    @AfterEach()
    public void AfterEachTest(){
        System.out.println("AfterEach");
    }

    @Test
    @BeforeAll
    public static void BeforeAllTest(){
        System.out.println("BeforeAll");
    }

    @Test
    @AfterAll
    public static void AfterAllTest(){
        System.out.println("AfterAll");
    }

    @Test
    @Timeout(value = 400,unit = TimeUnit.MILLISECONDS)
    public void TimeOutTest() throws InterruptedException {
        Thread.sleep(500);
    }

    @Test
    @DisplayName("simple assertion")
    public void simple(){
        Assertions.assertEquals(5,map(2,3),"计算错误");

        //Assertions.assertSame(new Object(),new Object());
        Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2});
    }

    public int map(int a,int b){
        return a+b;
    }

    @Test
    @DisplayName("超时测试")
    public void overTimeTest(){
        Assertions.assertTimeout(Duration.ofMillis(1000),()->Thread.sleep(500));
    }

    @Test
    @DisplayName("assert all")
    public void all(){
        Assertions.assertAll("math",
                () -> Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2}),
                () -> Assertions.assertNull(null));
    }

    @Test
    @DisplayName("assert all2")
    public void all2(){
        Assertions.assertAll("math",
                this::assertArrayEqualsTest,
                () -> Assertions.assertNull(null));
    }

    public void assertArrayEqualsTest(){
        Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2});
    }

    @Test
    @DisplayName("assert exception")
    public void exceptionTest(){
        String b;
       ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class,
                () -> System.out.println(10/0));
    }

    @DisplayName("Assumptions")
    @Test
    public void AssumptionTest(){
        Assumptions.assumeTrue(false,"错误了");
    }

    @ParameterizedTest
    @DisplayName("参数化测试1")
    @ValueSource(ints={1,2,3,4,5})
    public void parameterizedTest(Integer i){
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("参数化测试2")
    @MethodSource("method")
    public void methodTest(String name){
        System.out.println(name);
    }

    static Stream<String> method(){
        return Stream.of("apple","banana");
    }

}
