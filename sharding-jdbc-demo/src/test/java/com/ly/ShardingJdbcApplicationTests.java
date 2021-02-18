package com.ly;

import com.ly.bean.City;
import com.ly.bean.User;
import com.ly.bean.UserDetail;
import com.ly.repository.CityRepository;
import com.ly.repository.UserDetailRepository;
import com.ly.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShardingJdbcApplicationTests {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private CityRepository cityRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAdd(){


        for(int i =0 ; i< 20 ; i++){

            User user = new User();
            // 因为分片键位id 所以这里要为id赋值
            // user.setId(i);

            user.setName("张三");

            user.setAge(20);

            user.setAddress("北京市");

            user.setCreate_datetime(new Date());

            userRepository.save(user);



        }


    }

    @Test
    public void testAdd2(){


        for(int i =0 ; i< 20 ; i++){

            User user = new User();
            // 因为分片键位id 所以这里要为id赋值
            // user.setId(i);

            user.setName("张三");

            user.setAge(20);

            user.setAddress("北京市");

            user.setCreate_datetime(new Date());

            userRepository.save(user);

            UserDetail userDetail = new UserDetail();

            userDetail.setPid(user.getId());

            userDetail.setDescription("this is a description");

            userDetailRepository.save(userDetail);

        }


    }


    @Test
    public void testBroadcast(){


        City city = new City();

        city.setName("beijing");

        city.setProvince("beijing");


        cityRepository.save(city);

    }


    @Test
    public void testQuery(){


        Object object = userRepository.queryUserById(564105761370669056L);

        Object[] user = (Object[])object;

        System.out.println(user[0] + " " + user[1] + " " + user[2] + " " + user[3] + " " + user[4] );

    }




    public static void main(String[] args) {
        System.out.println("");
    }

}
