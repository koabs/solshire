package com.solshire.test;

import com.github.pagehelper.PageInfo;
import com.solshire.model.domain.City;
import com.solshire.service.CityService;
import com.solshire.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ApplicationTests extends SpringBaseTest {

    @Autowired
    private CityService cityService;

    @Test
    public void selectPage() {
        PageInfo<City> pageInfo = cityService.selectPageAndCount(null, 1, 3);
        log.info("--- start ---");
        pageInfo.getList().stream().map(JsonUtils::toJson).forEach(log::info);
        log.info("--- end ---");
    }

}