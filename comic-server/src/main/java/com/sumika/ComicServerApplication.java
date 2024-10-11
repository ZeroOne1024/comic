package com.sumika;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableTransactionManagement //事务
@EnableCaching //缓存
@EnableScheduling //任务调度
@Slf4j
public class ComicServerApplication {

	public static void main(String[] args) {
		System.out.println("""
                ___________________初音未来保佑你的项目顺利运行!_
                _______________#########_______________________
                ______________############_____________________
                ______________#############____________________
                _____________##__###########___________________
                ____________###__######_#####__________________
                ____________###_#######___####_________________
                ___________###__##########_####________________
                __________####__###########_####_______________
                ________#####___###########__#####_____________
                _______######___###_########___#####___________
                _______#####___###___########___######_________
                ______######___###__###########___######_______
                _____######___####_##############__######______
                ____#######__#####################_#######_____
                ____#######__##############################____
                ___#######__######_#################_#######___
                ___#######__######_######_#########___######___
                ___#######____##__######___######_____######___
                ___#######________######____#####_____#####____
                ____######________#####_____#####_____####_____
                _____#####________####______#####_____###______
                ______#####_______###________###______#________
                ________##_______####________####______________""");


		SpringApplication.run(ComicServerApplication.class, args);
		log.info("服务成功启动...");
	}

}
